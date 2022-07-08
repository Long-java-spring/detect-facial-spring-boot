package com.iist.register.shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final String LOCAL_DATE = "yyyy-MM-dd";

    public static LocalDate parseFromDate(String localDate) {
        return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(LOCAL_DATE));
    }

    public static String formatToDate(LocalDate dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(LOCAL_DATE));
    }
}
