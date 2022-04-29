package com.symbiosis.app.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Stack;
import java.util.function.Function;

public class GenericSpecificationBuilder<T> {

    public Specification<T> build(Stack<?> stack, Function<SearchCriteria, Specification<T>> converter) {
        Stack<Specification<T>> specificationStack = new Stack<>();
        while (!stack.isEmpty()) {
            Object isOperand = stack.pop();

            if (!(isOperand instanceof String)) {
                specificationStack.push(converter.apply((SearchCriteria) isOperand));
            } else {
                Specification<T> firstOperand = specificationStack.pop();
                Specification<T> secondOperand = specificationStack.pop();
                if (isOperand.equals(SearchOperation.AND_OPERATOR)) {
                    specificationStack.push(Specification.where(firstOperand).and(secondOperand));
                } else if (isOperand.equals(SearchOperation.OR_OPERATOR)) {
                    specificationStack.push(Specification.where(firstOperand).or(secondOperand));
                }
            }
        }
        return specificationStack.pop();
    }
}
