package com.epam.rd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.dto.Board;
import com.epam.rd.dto.User;
import com.epam.rd.service.BoardService;
import com.epam.rd.service.SessionUserManager;

@Controller
public class HomeController {

    @Autowired
    private SessionUserManager sessionUserManager;

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    private ModelAndView home(ModelAndView modelAndView) {
        User currentUser = sessionUserManager.getCurrentSessionUser();
        List<Board> boards = boardService.findBoardsByUserLogin(currentUser.getLogin());

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("boards", boards);

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
