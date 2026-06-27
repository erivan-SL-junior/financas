package com.financas.demo.shared.exception;

public class DateFormatNullDateException extends RuntimeException {
    public DateFormatNullDateException() {
        super("Can not format a null date");
    }
}
