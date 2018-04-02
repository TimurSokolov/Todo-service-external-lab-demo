package com.epam.rd.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5444304031388128013L;

    public NotFoundException(String message) {
        super(message);
    }
}
