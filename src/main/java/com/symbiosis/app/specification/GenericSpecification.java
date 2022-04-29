package com.symbiosis.app.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.Locale;

@RequiredArgsConstructor
public class GenericSpecification<T extends Serializable> implements Specification<T>, Serializable {

    private final transient SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        String[] params = criteria.getKey().split("\\.");
        From<T, ?> from = root;
        String start = params[0];

        for (int i = 0; i < params.length - 1; i++) {
            from = from.join(start);
            start = params[i + 1];
        }

        Object value = criteria.getValue();

        if (value instanceof String && value.toString().equals("null")) {
            criteria.setOperation(SearchOperation.IS_NULL);
        }

        if (value instanceof String && value.toString().equals("notnull")) {
            criteria.setOperation(SearchOperation.NOT_NULL);
        }

        if (value.toString().equals("true") || value.toString().equals("false")) {
            return getPredicate(criteriaBuilder, from, start, Boolean.parseBoolean(value.toString()) ? 1 : 0);
        }

        // This is for enums, but not sure if it works
        if (from.get(start).getJavaType().isEnum()) {
            value = Enum.valueOf((Class<Enum>) from.get(start).getJavaType(), value.toString().toUpperCase(Locale.ROOT));
            return getPredicate(criteriaBuilder, from, start, value);
        }
        return getPredicate(criteriaBuilder, from, start, value);
    }

    private Predicate getPredicate(CriteriaBuilder criteriaBuilder, From<T, ?> from, String attribute, Object value) {
        switch (criteria.getOperation()) {
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(from.get(attribute), value.toString());
            case LESS_THAN:
                return criteriaBuilder.lessThan(from.get(attribute), value.toString());
            case EQUALITY:
                return criteriaBuilder.equal(from.get(attribute), value);
            case LIKE:
                return criteriaBuilder.like(from.get(attribute), "%" + value + "%");
            case NEGATION:
                return criteriaBuilder.notEqual(from.get(attribute), value);
            case IS_NULL:
                return criteriaBuilder.isNull(from.get(attribute));
            case NOT_NULL:
                return criteriaBuilder.isNotNull(from.get(attribute));
            default:
                return null;
        }
    }
}
