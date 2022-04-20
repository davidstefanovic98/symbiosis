package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Board;
import com.symbiosis.app.repository.BoardRepository;
import com.symbiosis.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Integer boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Board with id " + boardId + " not found")
                );
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board update(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteById(Integer boardId) {
        boardRepository.deleteById(boardId);
    }
}
