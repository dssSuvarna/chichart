package com.activ8.chichart.api.rest.resource.error;

import lombok.*;

import java.io.*;
import java.util.*;

@Value
public class ErrorResource implements Serializable {

    ErrorType errorType;
    String error;
    String errorDetail;
    ArrayList<FieldErrorResource> fieldErrors = new ArrayList<>();

    public ErrorResource() {
        this(null, null, null);
    }

    public ErrorResource(ErrorType errorType, String error) {
        this(errorType, error, null);
    }

    public ErrorResource(ErrorType errorType, String error, String errorDetail) {
        this.errorType = errorType;
        this.error = error;
        this.errorDetail = errorDetail;
    }

    public void addFieldError(String field, String message) {
        fieldErrors.add(new FieldErrorResource(field, message));
    }
}
