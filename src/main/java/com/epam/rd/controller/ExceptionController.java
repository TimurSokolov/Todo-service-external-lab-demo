package com.epam.rd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    /*
     * Обработка RuntimeException
     */
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler(RuntimeException re) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", re.getMessage());
        modelAndView.setViewName("error-page");
        return modelAndView;
    }
    
    /*
     * Обработка RuntimeException
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception re) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", re.getMessage());
        modelAndView.setViewName("error-page");
        return modelAndView;
    }
}
