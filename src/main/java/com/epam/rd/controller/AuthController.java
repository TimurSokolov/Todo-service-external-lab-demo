package com.epam.rd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExist;
import com.epam.rd.service.SessionUserManager;
import com.epam.rd.service.UserService;

/*
 * Контроллер для регистрации, авторизации и аутентификации
 */
@Controller
public class AuthController {

    @Autowired
    private SessionUserManager sessionUserManager;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView registration(ModelAndView modelAndView, User user) {
        modelAndView.setViewName("registration");
        
        if (StringUtils.isEmpty(user.getLogin())) {
            modelAndView.addObject("error", "Введите логин");
            return modelAndView;
        }

        try {
            userService.registerUser(user);
        } catch (UserAlreadyExist e) {
            modelAndView.addObject("error", "Такой пользователь уже существует");
            return modelAndView;
        }

        sessionUserManager.setCurrentSessionUser(user);
        modelAndView.addObject("currentUser", user);
        modelAndView.setViewName("redirect:");
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest request) {
        request.getSession().invalidate();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, User user) {
        Boolean authenticated = userService.authenticateUser(user);

        if (!authenticated) {
            modelAndView.addObject("error", "Неверный логин");
            modelAndView.setViewName("login");
            return modelAndView;
        }

        sessionUserManager.setCurrentSessionUser(user);
        modelAndView.setViewName("redirect:");
        return modelAndView;
    }
}
