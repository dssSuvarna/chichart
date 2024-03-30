package com.activ8.chichart.api.rest.handler;

import com.activ8.chichart.api.rest.resource.error.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.*;

@Component
public class ErrorResourceCreator {

    public ErrorResource createValidationErrorResource(MethodArgumentNotValidException exception) {
        ErrorResource errorResource = new ErrorResource(ErrorType.VALIDATION_ERROR, "Field validation errors");
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errorResource.addFieldError(fieldError.getField(), fieldError.getDefaultMessage()) );
        // some validation is for the class as a whole (eg PersonSearchResource). In these cases there are no errors recorded against
        // individual fields but against the object as a whole
        exception.getBindingResult().getGlobalErrors()
                .forEach(globalError -> errorResource.addFieldError(globalError.getObjectName(), globalError.getDefaultMessage()) );

        return errorResource;
    }

    public ErrorResource createErrorResource(ErrorType errorType, Exception exception) {
        return createErrorResource(errorType, ExceptionUtils.getRootCauseMessage(exception), exception);
    }

    public ErrorResource createErrorResource(ErrorType errorType, String message, Exception exception) {
        return new ErrorResource(errorType, message, ExceptionUtils.prettyPrintStackTrace(exception));
    }
}
