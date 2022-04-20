package com.symbiosis.app.service;

import com.symbiosis.app.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> findAll();

    Board findById(Integer boardId);

    Board save(Board board);

    Board update(Board board);

    void deleteById(Integer boardId);
}
