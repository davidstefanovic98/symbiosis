package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Label;
import com.symbiosis.app.repository.LabelRepository;
import com.symbiosis.app.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    @Override
    public List<Label> findAll(Specification<Label> specification, Sort sort) {
        return labelRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Label findById(Integer labelId) {
        return labelRepository.findById(labelId)
                .orElseThrow(() -> new NoSuchElementException("Label with id " + labelId + " not found"));
    }

    @Override
    public Label save(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label update(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public void deleteById(Integer labelId) {
        labelRepository.deleteById(labelId);
    }
}
