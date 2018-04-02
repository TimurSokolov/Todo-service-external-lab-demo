package com.epam.rd.exception;

public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 5444304031388128013L;

    public UnauthorizedException(String message) {
        super(message);
    }
}
