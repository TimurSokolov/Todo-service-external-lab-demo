package com.epam.rd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.rd.dto.User;
import com.epam.rd.repository.UserRepository;
import com.epam.rd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public Boolean authenticateUser(User user) {
        return userRepository.findUserByLogin(user.getLogin()).isPresent();
    }

}
