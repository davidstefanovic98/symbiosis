package com.symbiosis.app.controller;

import com.symbiosis.app.entity.CardItem;
import com.symbiosis.app.service.CardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card-items")
public class CardItemController {

    private final CardItemService cardItemService;

    @GetMapping
    public ResponseEntity<List<CardItem>> getAllCardItems(@RequestParam(required = false) Specification<CardItem> specification,
                                                          @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(cardItemService.findAll(specification, sort));
    }

    @GetMapping("/{cardItemId}")
    public ResponseEntity<CardItem> getCardItemById(@PathVariable Integer cardItemId) {
        return ResponseEntity.ok(cardItemService.findById(cardItemId));
    }

    @PostMapping
    public ResponseEntity<CardItem> saveCardItem(CardItem cardItem) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardItemService.save(cardItem));
    }

    @PutMapping
    public ResponseEntity<CardItem> updateCardItem(CardItem cardItem) {
        return ResponseEntity.ok(cardItemService.update(cardItem));
    }

    @DeleteMapping("/{cardItemId}")
    public void deleteCardItemById(@PathVariable Integer cardItemId) {
        cardItemService.deleteById(cardItemId);
    }
}
