package com.symbiosis.app.service.generic.impl;

import com.symbiosis.app.repository.generic.JpaSpecificationRepository;
import com.symbiosis.app.service.generic.GenericCrudService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
public class GenericCrudServiceImpl<T> implements GenericCrudService<T> {

    protected final JpaSpecificationRepository<T> repository;

    @Override
    public List<T> findAll(Specification<T> specification, Sort sort) {
        return repository.findAll(specification, sort);
    }

    @Override
    public T findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entity found with id: " + id));
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
