package com.financas.demo.user.exception;

public class UserCreatingMissingAtributesExeception extends RuntimeException {
    public UserCreatingMissingAtributesExeception() {
        super("User creation can not accept null name");
    }
}
