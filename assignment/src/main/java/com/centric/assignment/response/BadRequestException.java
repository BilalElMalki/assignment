package com.centric.assignment.response;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String s) {
        super(s);
    }
}
