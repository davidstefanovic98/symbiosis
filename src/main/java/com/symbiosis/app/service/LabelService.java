package com.symbiosis.app.service;

import com.symbiosis.app.entity.Label;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface LabelService {

    List<Label> findAll(Specification<Label> specification, Sort sort);

    Label findById(Integer labelId);

    Label save(Label label);

    Label update(Label label);

    void deleteById(Integer labelId);
}
