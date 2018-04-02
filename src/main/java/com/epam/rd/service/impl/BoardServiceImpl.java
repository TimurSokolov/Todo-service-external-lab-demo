package com.epam.rd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.rd.dto.Board;
import com.epam.rd.exception.NotFoundException;
import com.epam.rd.repository.BoardRepository;
import com.epam.rd.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board addNewBoard(Board board) {
        return boardRepository.addNewBoard(board);
    }

    @Override
    public List<Board> findBoardsByUserLogin(String login) {
        return boardRepository.findBoardsByUserLogin(login);
    }

    @Override
    public Board findBoardById(Long boardId) {
        Optional<Board> boardOpt = boardRepository.findBoardById(boardId);

        if (!boardOpt.isPresent()) {
            throw new NotFoundException("Доска не найдена");
        }

        return boardOpt.get();
    }

}
