package com.epam.rd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.rd.dto.User;
import com.epam.rd.exception.UserAlreadyExist;
import com.epam.rd.repository.UserRepository;
import com.epam.rd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean authenticateUser(User user) {
        return userRepository.findUserByLogin(user.getLogin()).isPresent();
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExist {
        return userRepository.addUser(user);
    }

}
