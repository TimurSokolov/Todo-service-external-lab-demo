package com.epam.rd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.dto.Board;
import com.epam.rd.service.BoardService;
import com.epam.rd.service.SessionUserManager;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private SessionUserManager sessionUserManager;

    @Autowired
    private BoardService boardService;

    @GetMapping("{id}")
    private ModelAndView boards(@PathVariable Long id, ModelAndView modelAndView) {
        Board board = boardService.findBoardById(id);
        modelAndView.addObject("board", board);
        modelAndView.setViewName("board");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping
    private Board addNewBoard(ModelAndView modelAndView) {
        Board board = new Board();
        String userLogin = sessionUserManager.getCurrentSessionUser().getLogin();

        board.setName("Новая доска");
        board.setUserLoginOwner(userLogin);

        return boardService.addNewBoard(board);
    }

}
