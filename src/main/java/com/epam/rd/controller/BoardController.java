package com.epam.rd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.dto.Board;
import com.epam.rd.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("{id}")
    private ModelAndView boards(@PathVariable Long id, ModelAndView modelAndView) {
        Board board = boardService.findBoardById(id);
        modelAndView.addObject("board", board);
        modelAndView.setViewName("board");
        return modelAndView;
    }

}
