package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Board;
import com.symbiosis.app.repository.BoardRepository;
import com.symbiosis.app.service.BoardService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl extends GenericCrudServiceImpl<Board> implements BoardService {

    protected BoardServiceImpl(BoardRepository repository) {
        super(repository);
    }
}
