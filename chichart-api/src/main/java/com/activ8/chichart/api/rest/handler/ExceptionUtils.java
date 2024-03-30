package com.activ8.chichart.api.rest.handler;

import org.hibernate.exception.*;

import java.io.*;

interface ExceptionUtils {

    static String getRootCauseMessage(Throwable throwable) {
        return org.apache.commons.lang3.exception.ExceptionUtils.getRootCauseMessage(throwable);
    }

    static String prettyPrintStackTrace(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    static boolean isConstraintViolation(Exception ex) {
        return org.apache.commons.lang3.exception.ExceptionUtils.indexOfThrowable(ex, ConstraintViolationException.class) >= 0;
    }
}
