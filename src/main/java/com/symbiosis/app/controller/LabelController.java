package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Card;
import com.symbiosis.app.entity.Label;
import com.symbiosis.app.service.CardService;
import com.symbiosis.app.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    @GetMapping("/label")
    public ResponseEntity<List<Label>> getAllLabels() {
        return ResponseEntity.ok(labelService.findAll());
    }

    @PostMapping("/label")
    public ResponseEntity<Label> saveLabel(Label label) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(labelService.save(label));
    }

    @PutMapping("/label")
    public ResponseEntity<Label> updateLabel(Label label) {
        return ResponseEntity.ok(labelService.update(label));
    }

    @DeleteMapping("/label/{labelId}")
    public void deleteLabelById(@PathVariable Integer labelId) {
        labelService.deleteById(labelId);
    }
}
