package com.epam.rd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UnauthorizedException;
import com.epam.rd.exception.UserAlreadyExistException;
import com.epam.rd.service.SessionUserManager;
import com.epam.rd.service.UserService;

/**
 * Контроллер для регистрации, авторизации и аутентификации
 */
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private SessionUserManager sessionUserManager;

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /*
     * Аннотация @Validated указывает на то, что объект User должен пройти валидацию при обращении к данному методу.
     * Правила валидации указываются в самом классе User. BindingResult автоматически принимает результаты валидации.
     * Метод hasErrors() возвращает флаг наличия ошибок валидации.
     */
    @PostMapping("registration")
    public ModelAndView registration(ModelAndView modelAndView, @Validated User user, BindingResult result) {
        modelAndView.setViewName("registration");
        
       

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            modelAndView.addObject("errors", errors);
            return modelAndView;
        }

        try {
            userService.registerUser(user);
        } catch (UserAlreadyExistException e) {
            modelAndView.addObject("errors", "Такой пользователь уже существует");
            return modelAndView;
        }

        sessionUserManager.setCurrentSessionUser(user);
        modelAndView.addObject("currentUser", user);
        modelAndView.setViewName("redirect:");
        return modelAndView;
    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest request) {
        request.getSession().invalidate();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    /**
     * Проверка на существование пользователя с таким логином
     */
    @ResponseBody
    @GetMapping("checkloginexist")
    public Boolean login(@RequestParam String login) {
        return userService.checkLoginExist(login);
    }

    @GetMapping("login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView, User user) {
        User foundUser;

        try {
            foundUser = userService.authenticateUser(user);
        } catch (UnauthorizedException e) {
            modelAndView.addObject("error", "Неверный логин или пароль");
            modelAndView.setViewName("login");
            return modelAndView;
        }

        sessionUserManager.setCurrentSessionUser(foundUser);
        modelAndView.setViewName("redirect:");

        return modelAndView;
    }
}
