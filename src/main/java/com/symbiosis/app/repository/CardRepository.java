package com.symbiosis.app.repository;

import com.symbiosis.app.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardRepository extends JpaRepository<Card, Integer>, JpaSpecificationExecutor<Card> {

}

