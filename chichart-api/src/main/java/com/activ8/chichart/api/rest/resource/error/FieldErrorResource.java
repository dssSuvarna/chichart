package com.activ8.chichart.api.rest.resource.error;

import lombok.*;

import java.io.*;

@Value
public class FieldErrorResource implements Serializable {

    String field;
    String message;

    public FieldErrorResource() {
        this(null, null);
    }

    public FieldErrorResource(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
