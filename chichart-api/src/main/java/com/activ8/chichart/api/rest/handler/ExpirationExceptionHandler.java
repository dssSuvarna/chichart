package com.activ8.chichart.api.rest.handler;

import com.activ8.chichart.api.exception.*;
import com.activ8.chichart.api.rest.resource.error.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.core.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ExpirationExceptionHandler {


    private final ErrorResourceCreator errorResourceCreator;

    @Autowired
    public ExpirationExceptionHandler(ErrorResourceCreator errorResourceCreator) {
        this.errorResourceCreator = errorResourceCreator;
    }

    @ExceptionHandler(value = {TrialPeriodExpiredException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResource trialPeriodExpiredHandler(Exception ex) {
        LOGGER.debug("Trial period expired", ex);
        return errorResourceCreator.createErrorResource(ErrorType.BAD_REQUEST, ex);
    }
}
