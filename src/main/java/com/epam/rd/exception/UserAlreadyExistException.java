package com.epam.rd.exception;

public class UserAlreadyExistException extends Exception {

    private static final long serialVersionUID = 9156950209954533944L;

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
