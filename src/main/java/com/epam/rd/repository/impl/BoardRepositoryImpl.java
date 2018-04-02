package com.epam.rd.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.epam.rd.dto.Board;
import com.epam.rd.repository.BoardRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private Long boardId;
    private List<Board> boards;

    public BoardRepositoryImpl() {
        boardId = 0L;
        boards = new ArrayList<>();

        String defaultLogin = "Tim";

        Board workBoard = new Board(getNextBoardId(), "Рабочие задачи", defaultLogin);
        Board homeBoard = new Board(getNextBoardId(), "Домашние задачи", defaultLogin);

        boards.add(workBoard);
        boards.add(homeBoard);
    }

    @Override
    public List<Board> findBoardsByUserLogin(String login) {
        return boards.stream()
                .filter(board -> board.getUserLoginOwner().equals(login))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Board> findBoardById(Long boardId) {
        return boards.stream()
                .filter(board -> board.getId() == boardId)
                .findFirst();
    }

    @Override
    public Board addNewBoard(Board board) {
        board.setId(getNextBoardId());
        boards.add(board);
        return board;
    }

    private Long getNextBoardId() {
        return ++boardId;
    }
}
