package com.epam.rd.exception;

public class UserAlreadyExist extends RuntimeException {

    private static final long serialVersionUID = 9156950209954533944L;

    public UserAlreadyExist(String message) {
        super(message);
    }
}
