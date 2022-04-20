package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Board;
import com.symbiosis.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @PostMapping("/board")
    public ResponseEntity<Board> saveBoard(Board board) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(boardService.save(board));
    }

    @PutMapping("/board")
    public ResponseEntity<Board> updateBoard(Board board) {
        return ResponseEntity.ok(boardService.update(board));
    }

    @DeleteMapping("/board/{boardId}")
    public void deleteBoardById(@PathVariable Integer boardId) {
        boardService.deleteById(boardId);
    }
}
