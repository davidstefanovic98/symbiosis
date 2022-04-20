package com.symbiosis.app.repository;

import com.symbiosis.app.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
