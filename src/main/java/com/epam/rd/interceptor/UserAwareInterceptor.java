package com.epam.rd.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.epam.rd.dto.User;
import com.epam.rd.service.SessionUserManager;

public class UserAwareInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserManager sessionUserManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = sessionUserManager.getCurrentSessionUser();

        if (Objects.nonNull(user)) {
            request.setAttribute("user", user);
        }

        return true;

    }

}
