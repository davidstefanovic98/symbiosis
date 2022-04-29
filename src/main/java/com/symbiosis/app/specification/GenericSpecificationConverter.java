package com.symbiosis.app.specification;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Stack;

@Component
public class GenericSpecificationConverter implements Converter<String, Specification<?>> {

    @Override
    public Specification<?> convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        try {
            Stack<?> stack = new CriteriaParser().parse(source);
            GenericSpecificationBuilder<? extends Serializable> specificationBuilder = new GenericSpecificationBuilder<>();
            return specificationBuilder.build(stack, GenericSpecification::new);
        } catch (Exception e) {
            return null;
        }
    }
}
