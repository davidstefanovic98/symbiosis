package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Label;
import com.symbiosis.app.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    @GetMapping
    public ResponseEntity<List<Label>> getAllLabels(@RequestParam(required = false) Specification<Label> specification, @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(labelService.findAll(specification, sort));
    }

    @GetMapping("/{labelId}")
    public ResponseEntity<Label> getLabelById(@PathVariable Integer labelId) {
        return ResponseEntity.ok(labelService.findById(labelId));
    }

    @PostMapping
    public ResponseEntity<Label> saveLabel(Label label) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(labelService.save(label));
    }

    @PutMapping
    public ResponseEntity<Label> updateLabel(Label label) {
        return ResponseEntity.ok(labelService.update(label));
    }

    @DeleteMapping("/{labelId}")
    public void deleteLabelById(@PathVariable Integer labelId) {
        labelService.deleteById(labelId);
    }
}
