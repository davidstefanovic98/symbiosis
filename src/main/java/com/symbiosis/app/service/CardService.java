package com.symbiosis.app.service;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.entity.Label;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CardService {

    List<Card> findAll(Specification<Card> specification, Sort sort);

    Card findById(Integer cardId);

    Card save(Card card);

    Card update(Card card);

    void deleteById(Integer cardId);
}
