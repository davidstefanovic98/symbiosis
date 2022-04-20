package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.entity.Label;
import com.symbiosis.app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping("/card")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @PostMapping("/card")
    public ResponseEntity<Card> saveCard(Card card) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardService.save(card));
    }

    @PutMapping("/card")
    public ResponseEntity<Card> updateCard(Card card) {
        return ResponseEntity.ok(cardService.update(card));
    }

    @DeleteMapping("/card/{cardId}")
    public void deleteCardById(@PathVariable Integer cardId) {
        cardService.deleteById(cardId);
    }

    @GetMapping("/label/{cardId}")
    public ResponseEntity<List<Label>> getAllLabelsByCardId(@PathVariable Integer cardId) {
        return ResponseEntity.ok(cardService.findAllLabelsByCardId(cardId));
    }
}
