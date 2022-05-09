package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.CardItem;
import com.symbiosis.app.repository.CardItemRepository;
import com.symbiosis.app.service.CardItemService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CardItemServiceImpl extends GenericCrudServiceImpl<CardItem> implements CardItemService {

    protected CardItemServiceImpl(CardItemRepository repository) {
        super(repository);
    }
}

