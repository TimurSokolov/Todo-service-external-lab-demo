package com.epam.rd.service;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExistException;

public interface UserService {
    
    User registerUser(User user) throws UserAlreadyExistException;

    User authenticateUser(User user);
    
    Boolean checkLoginExist(String login);
}
