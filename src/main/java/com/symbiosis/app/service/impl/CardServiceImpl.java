package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.repository.CardRepository;
import com.symbiosis.app.service.CardService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends GenericCrudServiceImpl<Card> implements CardService {

    protected CardServiceImpl(CardRepository repository) {
        super(repository);
    }
}
