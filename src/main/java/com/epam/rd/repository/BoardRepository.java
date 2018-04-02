package com.epam.rd.repository;

import java.util.List;
import java.util.Optional;

import com.epam.rd.dto.Board;

public interface BoardRepository {
    
    Board addNewBoard(Board board);

    List<Board> findBoardsByUserLogin(String login);

    Optional<Board> findBoardById(Long boardId);

}
