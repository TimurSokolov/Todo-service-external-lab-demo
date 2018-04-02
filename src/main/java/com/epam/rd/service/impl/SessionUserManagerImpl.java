package com.epam.rd.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.epam.rd.dto.User;
import com.epam.rd.service.SessionUserManager;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class SessionUserManagerImpl implements SessionUserManager{
    
    private User currentSessionUser;

    @Override
    public User setCurrentSessionUser(User user) {
        this.currentSessionUser = user;
        return this.currentSessionUser;
    }

    @Override
    public User getCurrentSessionUser() {
        return this.currentSessionUser;
    }

}
