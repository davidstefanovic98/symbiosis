package com.symbiosis.app.service;

import com.symbiosis.app.entity.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BoardService {

    List<Board> findAll(Specification<Board> specification, Sort sort);

    Board findById(Integer boardId);

    Board save(Board board);

    Board update(Board board);

    void deleteById(Integer boardId);
}
