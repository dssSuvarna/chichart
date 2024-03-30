package com.activ8.chichart.core;

import java.time.*;
import java.util.*;

public class DateUtils {

    public static Date asDate(LocalDate date) {
        if (date != null) {
            return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } else {
            return null;
        }
    }

    public static Date asDate(LocalDateTime date) {
        if (date != null) {
            return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        } else {
            return null;
        }
    }

    public static LocalDate asLocalDate(final java.sql.Date date) {

        if (date != null) {
            return date.toLocalDate();
        } else {
            return null;
        }
    }

    public static LocalDate asLocalDate(final LocalDateTime date) {

        if (date != null) {
            return date.toLocalDate();
        } else {
            return null;
        }
    }

    public static LocalDate asLocalDate(final Date date) {

        if (date == null) {
            return null;
        } else if (date instanceof java.sql.Date) {
            /// java.sql.Date doesnt support toInstant(), as it has no time component. It throws an UnsupporterOperationException.
            return ((java.sql.Date) date).toLocalDate();
        } else {
            final LocalDateTime dateTime = asLocalDateTime(date);
            return dateTime.toLocalDate();
        }
    }

    private static LocalDateTime asLocalDateTime(final Date date) {
        return asLocalDateTime(date, ZoneId.systemDefault());
    }

    public static LocalDateTime asLocalDateTime(final LocalDate date) {
        if (date != null) {
            return date.atStartOfDay();
        } else {
            return null;
        }

    }

    private static LocalDateTime asLocalDateTime(final Date date, ZoneId zoneId) {
        if (date != null) {
            return LocalDateTime.ofInstant(date.toInstant(), zoneId);
        } else {
            return null;
        }
    }

}