package com.symbiosis.app.service;

import com.symbiosis.app.entity.CardItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CardItemService {

    List<CardItem> findAll(Specification<CardItem> specification, Sort sort);

    CardItem findById(Integer cardItemId);

    CardItem save(CardItem cardItem);

    CardItem update(CardItem cardItem);

    void deleteById(Integer cardItemId);
}
