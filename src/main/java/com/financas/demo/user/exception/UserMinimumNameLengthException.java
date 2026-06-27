package com.financas.demo.user.exception;

public class UserMinimumNameLengthException extends RuntimeException {
    public UserMinimumNameLengthException() {
        super("User name length can not be shorter than 4");
    }
}
