package com.epam.rd.service;

import com.epam.rd.dto.User;

public interface UserService {

    User addUser(User user);

    Boolean authenticateUser(User user);
}
