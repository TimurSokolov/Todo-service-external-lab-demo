package com.epam.rd.service;

import java.util.List;

import com.epam.rd.dto.Board;

public interface BoardService {

    Board addNewBoard(Board board);

    List<Board> findBoardsByUserLogin(String login);

    Board findBoardById(Long boardId);
}
