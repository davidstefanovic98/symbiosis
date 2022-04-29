package com.symbiosis.app.specification;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SearchCriteria implements Serializable {

    private String key;
    private SearchOperation operation;
    private Object value;
    private boolean or;

    public SearchCriteria(String key, String operation, String value) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        this.key = key;
        this.operation = op;
        this.value = value;
    }
}
