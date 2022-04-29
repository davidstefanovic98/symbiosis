package com.symbiosis.app.specification;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CriteriaParser {

    private static final Map<String, Operator> operators;

    static {
        operators = Map.of("AND", Operator.AND,
                "OR", Operator.OR,
                "and", Operator.AND,
                "or", Operator.OR);
    }

    private static final Pattern specificationRegex =
            Pattern.compile("^([\\w.]+?)(" +
                    String.join("|" , SearchOperation.SIMPLE_OPERATIONS) +
                    ")([\\w-:/.@#$^\\s+]+?)$");

    public Stack<?> parse(String param) {
        Stack<Object> resultStack = new Stack<>();
        Stack<String> operatorsStack = new Stack<>();
        String[] parts = param.split("\\s+");

        Arrays.stream(parts).forEach(operator -> {
            if (operators.containsKey(operator)) {
                while (!operatorsStack.isEmpty() && (operators.containsKey(operatorsStack.peek()) &&
                        operators.get(operatorsStack.peek()).getPrecedence() >= operators.get(operator).getPrecedence()))
                    resultStack.push(operatorsStack.pop()
                            .equalsIgnoreCase("or") ? SearchOperation.OR_OPERATOR : SearchOperation.AND_OPERATOR);
                operatorsStack.push(operator.equalsIgnoreCase("or") ? SearchOperation.OR_OPERATOR : SearchOperation.AND_OPERATOR);
            } else if (operator.equals(SearchOperation.LEFT_PARENTHESIS)) {
                operatorsStack.push(operator);
            } else if (operator.equals(SearchOperation.RIGHT_PARENTHESIS)) {
                while (!operatorsStack.peek().equals(SearchOperation.LEFT_PARENTHESIS))
                    resultStack.push(operatorsStack.pop());
                operatorsStack.pop();
            } else {
                Matcher matcher = specificationRegex.matcher(operator);
                while (matcher.find()) {
                    resultStack.push(new SearchCriteria(matcher.group(1),
                            matcher.group(2),
                            matcher.group(3)));
                }
            }
        });
        while (!operatorsStack.isEmpty())
            resultStack.push(operatorsStack.pop());

        return resultStack;
    }

    private enum Operator {
        OR(1), AND(2);
        final int precedence;

        Operator(int precedence) {
            this.precedence = precedence;
        }

        public int getPrecedence() {
            return precedence;
        }
    }
}
