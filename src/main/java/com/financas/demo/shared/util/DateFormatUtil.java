package com.financas.demo.shared.util;

import com.financas.demo.shared.exception.DateFormatNullDateException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class DateFormatUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static String format(LocalDateTime dateTime) {
        DateFormatUtil.validateNullDate(dateTime);

        return dateTime.format(FORMATTER);
    }

    private static void validateNullDate(Temporal date) {
        if (date == null)
            throw new DateFormatNullDateException();
    }
}
