package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Label;
import com.symbiosis.app.repository.LabelRepository;
import com.symbiosis.app.service.LabelService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl extends GenericCrudServiceImpl<Label> implements LabelService {

    protected LabelServiceImpl(LabelRepository repository) {
        super(repository);
    }
}
