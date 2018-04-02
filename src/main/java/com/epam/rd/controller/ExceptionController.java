package com.epam.rd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler(RuntimeException re) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", re);
        modelAndView.setViewName("forward:/error-page");
        return modelAndView;
    }
}
