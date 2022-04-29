package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Board;
import com.symbiosis.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards(@RequestParam Specification<Board> specification, @RequestParam Sort sort) {
        return ResponseEntity.ok(boardService.findAll(specification, sort));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoardById(@PathVariable Integer boardId) {
        return ResponseEntity.ok(boardService.findById(boardId));
    }

    @PostMapping
    public ResponseEntity<Board> saveBoard(Board board) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(boardService.save(board));
    }

    @PutMapping
    public ResponseEntity<Board> updateBoard(Board board) {
        return ResponseEntity.ok(boardService.update(board));
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoardById(@PathVariable Integer boardId) {
        boardService.deleteById(boardId);
    }
}
