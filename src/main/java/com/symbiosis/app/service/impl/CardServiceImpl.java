package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.entity.Label;
import com.symbiosis.app.repository.CardRepository;
import com.symbiosis.app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(Integer cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Card with id " + cardId + " not found")
                );
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteById(Integer cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public List<Label> findAllLabelsByCardId(Integer cardId) {
        Card card = findById(cardId);
        return card.getLabels();
    }
}
