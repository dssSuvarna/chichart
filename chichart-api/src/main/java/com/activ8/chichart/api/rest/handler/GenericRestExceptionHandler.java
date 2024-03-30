package com.activ8.chichart.api.rest.handler;


import com.activ8.chichart.api.rest.exception.*;
import com.activ8.chichart.api.rest.resource.error.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.core.convert.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.nio.file.*;

@ControllerAdvice
//@Order defaults to lowest precedence
@Order
@Slf4j
public class GenericRestExceptionHandler {

    private final ErrorResourceCreator errorResourceCreator;

    @Autowired
    public GenericRestExceptionHandler(ErrorResourceCreator errorResourceCreator) {
        this.errorResourceCreator = errorResourceCreator;
    }

    @ExceptionHandler(value = {
            BadRequestException.class,
            ServletRequestBindingException.class,
            ConversionFailedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResource badRequestHandler(Exception ex) {
        LOGGER.debug("Bad request to REST Controller", ex);
        return errorResourceCreator.createErrorResource(ErrorType.BAD_REQUEST, ex);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResource accessDeniedHandler(Exception ex) {
        LOGGER.debug("Access denied to REST Controller", ex);
        return errorResourceCreator.createErrorResource(ErrorType.UNAUTHORISED, ex);
    }

    @ExceptionHandler(value = {
            RestClientResponseException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResource restClientException(RestClientResponseException ex) {
        LOGGER.error("Error Response headers: {}", ex.getResponseHeaders());
        LOGGER.error("Error Response body: {}", ex.getResponseBodyAsString());
        LOGGER.error("Unhandled exception in outgoing REST client communications", ex);
        return errorResourceCreator.createErrorResource(
                ErrorType.GENERAL_ERROR,
                String.format("Unhandled exception in outgoing REST client communications, check logs for details: %s", ExceptionUtils.getRootCauseMessage(ex)),
                ex);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResource genericExceptionHandler(Exception ex) {
        LOGGER.error("Unhandled exception in REST Controller", ex);
        return errorResourceCreator.createErrorResource(
                ErrorType.GENERAL_ERROR,
                String.format("Unhandled exception in REST controller, check logs for details: %s", ExceptionUtils.getRootCauseMessage(ex)),
                ex);
    }
}
