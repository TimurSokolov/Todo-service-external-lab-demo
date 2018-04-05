package com.epam.rd.repository;

import java.util.Optional;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExistException;

public interface UserRepository {

    User addUser(User user) throws UserAlreadyExistException;

    Optional<User> findUserByLogin(String login);
}
