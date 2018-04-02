package com.epam.rd.service;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExist;

public interface UserService {
    
    User registerUser(User user) throws UserAlreadyExist;

    Boolean authenticateUser(User user);
}
