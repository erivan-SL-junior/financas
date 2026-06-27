package com.financas.demo.user.exception;

public class UserUpdateEmptyException extends RuntimeException {
    public UserUpdateEmptyException() {
        super("User has no name or active stats, cannot be updated");
    }
}
