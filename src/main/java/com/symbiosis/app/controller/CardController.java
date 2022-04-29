package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(@RequestParam(required = false) Specification<Card> specification,
                                                  @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(cardService.findAll(specification, sort));
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer cardId) {
        return ResponseEntity.ok(cardService.findById(cardId));
    }

    @PostMapping
    public ResponseEntity<Card> saveCard(Card card) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardService.save(card));
    }

    @PutMapping
    public ResponseEntity<Card> updateCard(Card card) {
        return ResponseEntity.ok(cardService.update(card));
    }

    @DeleteMapping("/{cardId}")
    public void deleteCardById(@PathVariable Integer cardId) {
        cardService.deleteById(cardId);
    }

}
