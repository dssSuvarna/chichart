package com.activ8.chichart.api.rest.handler;

import com.activ8.chichart.api.rest.resource.error.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.core.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

/**
 * Class that handles JSR-303 field validation errors (ie created when we use annotations like @Valid on a request body and/or
 * NotBlank and Size on fields in Resource classes
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MethodArgumentNotValidExceptionHandler {

    private final ErrorResourceCreator errorResourceCreator;

    @Autowired
    public MethodArgumentNotValidExceptionHandler(ErrorResourceCreator errorResourceCreator) {
        this.errorResourceCreator = errorResourceCreator;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResource methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return errorResourceCreator.createValidationErrorResource(ex);
    }

}
