package com.epam.rd.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UnauthorizedException;
import com.epam.rd.exception.UserAlreadyExistException;
import com.epam.rd.repository.UserRepository;
import com.epam.rd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticateUser(User user) throws UnauthorizedException {
        Optional<User> foundUserOpt = userRepository.findUserByLogin(user.getLogin());

        User foundUser = foundUserOpt.orElseThrow(() -> new UnauthorizedException("Пользователь не авторизован"));

        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new UnauthorizedException("Пользователь не авторизован");
        }

        return foundUser;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistException {
        return userRepository.addUser(user);
    }

    @Override
    public Boolean checkLoginExist(String login) {
        return userRepository.findUserByLogin(login).isPresent();
    }

}
