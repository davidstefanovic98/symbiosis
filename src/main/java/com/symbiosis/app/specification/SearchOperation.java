package com.symbiosis.app.specification;

import java.util.Arrays;

public enum SearchOperation {

    EQUALITY('='),
    NEGATION('!'),
    GREATER_THAN('>'),
    LESS_THAN('<'),
    LIKE('~'),
    IS_NULL((char) 0),
    NOT_NULL((char) 0);

    private final char symbol;

    public static final String[] SIMPLE_OPERATIONS = {"=", "!", ">", "<", "~"};

    public static final String OR_OPERATOR = "OR";

    public static final String AND_OPERATOR = "AND";

    public static final String LEFT_PARENTHESIS = "(";

    public static final String RIGHT_PARENTHESIS = ")";


    public char getSymbol() {
        return symbol;
    }

    SearchOperation(char symbol) {
        this.symbol = symbol;
    }

    public static SearchOperation getSimpleOperation(final char string) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol == string)
                .findFirst()
                .orElse(null);
    }
}
