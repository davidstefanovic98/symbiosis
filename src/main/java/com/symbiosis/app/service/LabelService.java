package com.symbiosis.app.service;

import com.symbiosis.app.entity.Label;

import java.util.List;

public interface LabelService {

    List<Label> findAll();

    Label findById(Integer labelId);

    Label save(Label label);

    Label update(Label label);

    void deleteById(Integer labelId);
}
