package com.symbiosis.app.service.generic;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface GenericCrudService<T> {

    List<T> findAll(Specification<T> specification, Sort sort);

    T findById(Integer id);

    T save(T entity);

    T update(T entity);

    void deleteById(Integer id);
}
