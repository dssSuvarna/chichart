package com.activ8.chichart.api.rest.handler;

import com.activ8.chichart.api.rest.resource.error.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.core.annotation.*;
import org.springframework.dao.*;
import org.springframework.http.*;
import org.springframework.orm.jpa.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class PersistenceExceptionHandler {


    private final ErrorResourceCreator errorResourceCreator;

    @Autowired
    public PersistenceExceptionHandler(ErrorResourceCreator errorResourceCreator) {
        this.errorResourceCreator = errorResourceCreator;
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResource entityNotFoundHandler(Exception ex) {
        LOGGER.debug("Entity Not Found", ex);
        return errorResourceCreator.createErrorResource(ErrorType.NOT_FOUND, ex);
    }

    @ExceptionHandler(value = {
            PersistenceException.class,
            JpaSystemException.class,
            DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResource persistenceExceptionHandler(Exception ex) {
        LOGGER.error("Persistence exception in REST method", ex);

        ErrorType errortype;
        if (ExceptionUtils.isConstraintViolation(ex)) {
            errortype = ErrorType.CONSTRAINT_VIOLATION;
        } else {
            errortype = ErrorType.BAD_REQUEST;
        }

        return errorResourceCreator.createErrorResource(errortype, ex);
    }
}
