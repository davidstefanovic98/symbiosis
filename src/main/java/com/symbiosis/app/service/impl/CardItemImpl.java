package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.CardItem;
import com.symbiosis.app.repository.CardItemRepository;
import com.symbiosis.app.service.CardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CardItemImpl implements CardItemService {

    private final CardItemRepository cardItemRepository;

    @Override
    public List<CardItem> findAll(Specification<CardItem> specification, Sort sort) {
        return cardItemRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public CardItem findById(Integer cardItemId) {
        return cardItemRepository.findById(cardItemId)
                .orElseThrow(() -> new NoSuchElementException("Card with id " + cardItemId + "not found"));
    }

    @Override
    public CardItem save(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public CardItem update(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public void deleteById(Integer cardItemId) {
        cardItemRepository.deleteById(cardItemId);
    }
}

