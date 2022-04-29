package com.symbiosis.app.specification;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CriteriaParserTest {

    @Test
    void parseSimpleEquality() {
        String criteria = "( id=1 )";
        Stack<SearchCriteria> stack = (Stack<SearchCriteria>) new CriteriaParser().parse(criteria);
        assertEquals(1, stack.size());
        SearchCriteria searchCriteria = stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("1", searchCriteria.getValue());
    }

    @Test
    void parseAndOperator() {
        String criteria = "( id=1 ) AND ( name!2 )";
        Stack<?> stack = new CriteriaParser().parse(criteria);
        assertEquals(3, stack.size());
        String operator = (String) stack.pop();
        assertEquals(SearchOperation.AND_OPERATOR, operator);
        SearchCriteria searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.NEGATION, searchCriteria.getOperation());
        assertEquals("2", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("1", searchCriteria.getValue());
    }

    @Test
    void parseOrOperator() {
        String criteria = "( id>1 OR name<2 )";
        Stack<?> stack = new CriteriaParser().parse(criteria);
        assertEquals(3, stack.size());
        String operator = (String) stack.pop();
        assertEquals(SearchOperation.OR_OPERATOR, operator);
        SearchCriteria searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.LESS_THAN, searchCriteria.getOperation());
        assertEquals("2", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.GREATER_THAN, searchCriteria.getOperation());
        assertEquals("1", searchCriteria.getValue());
    }

    @Test
    void parseMultipleOperators() {
        String criteria = "( ( id>1 OR name<2 ) AND ( id=3 OR name=4 ) )";
        Stack<?> stack = new CriteriaParser().parse(criteria);
        assertEquals(7, stack.size());
        String operator = (String) stack.pop();
        assertEquals(SearchOperation.AND_OPERATOR, operator);
        operator = (String) stack.pop();
        assertEquals(SearchOperation.OR_OPERATOR, operator);
        SearchCriteria searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("4", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("3", searchCriteria.getValue());
        operator = (String) stack.pop();
        assertEquals(SearchOperation.OR_OPERATOR, operator);
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.LESS_THAN, searchCriteria.getOperation());
        assertEquals("2", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.GREATER_THAN, searchCriteria.getOperation());
        assertEquals("1", searchCriteria.getValue());
    }

    @Test
    void parseMultipleOperatorsWithoutParenthesis() {
        String criteria = "(  id>1 OR name<2  AND  id=3 OR name=4  )";
        Stack<?> stack = new CriteriaParser().parse(criteria);
        assertEquals(7, stack.size());
        String operator = (String) stack.pop();
        assertEquals(SearchOperation.OR_OPERATOR, operator);
        SearchCriteria searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("4", searchCriteria.getValue());
        operator = (String) stack.pop();
        assertEquals(SearchOperation.OR_OPERATOR, operator);
        operator = (String) stack.pop();
        assertEquals(SearchOperation.AND_OPERATOR, operator);
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.EQUALITY, searchCriteria.getOperation());
        assertEquals("3", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("name", searchCriteria.getKey());
        assertEquals(SearchOperation.LESS_THAN, searchCriteria.getOperation());
        assertEquals("2", searchCriteria.getValue());
        searchCriteria = (SearchCriteria) stack.pop();
        assertEquals("id", searchCriteria.getKey());
        assertEquals(SearchOperation.GREATER_THAN, searchCriteria.getOperation());
        assertEquals("1", searchCriteria.getValue());
    }
}