package com.symbiosis.app.service;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.entity.Label;

import java.util.List;

public interface CardService {

    List<Card> findAll();

    Card findById(Integer cardId);

    Card save(Card card);

    Card update(Card card);

    void deleteById(Integer cardId);

    List<Label> findAllLabelsByCardId(Integer cardId);
}
