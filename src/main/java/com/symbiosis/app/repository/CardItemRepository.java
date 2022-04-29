package com.symbiosis.app.repository;

import com.symbiosis.app.entity.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardItemRepository extends JpaRepository<CardItem, Integer>, JpaSpecificationExecutor<CardItem> {

}
