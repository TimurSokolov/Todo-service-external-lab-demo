package com.epam.rd.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExist;
import com.epam.rd.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users;

    public UserRepositoryImpl() {
        super();
        this.users = new ArrayList<>();
    }

    @Override
    public User addUser(User newUser) throws UserAlreadyExist {
        boolean loginExist = users.stream().anyMatch(user -> user.getLogin().equals(newUser.getLogin()));

        if (loginExist) {
            throw new UserAlreadyExist("Такой пользователь уже существует");
        } else {
            users.add(newUser);
        }

        return newUser;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

}
