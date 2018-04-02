package com.epam.rd.repository;

import java.util.Optional;

import com.epam.rd.dto.User;

public interface UserRepository {

    User addUser(User user);

    Optional<User> findUserByLogin(String login);
}
