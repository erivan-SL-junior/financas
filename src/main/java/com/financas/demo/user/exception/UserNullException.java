package com.financas.demo.user.exception;

public class UserNullException extends RuntimeException {
    public UserNullException() {
        super("User can not be null");
    }
}
