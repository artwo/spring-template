package com.template.controller;

import com.template.model.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice(assignableTypes = DemoController.class)
public class DemoControllerAdvice {

    private static void logError(ErrorResponse error) {
        log.error(
                String.format(
                        "Sending error response code: %s message: %s exception: %s",
                        error.getCode(), error.getMessage(), error.getExceptionMessage()));
    }

    private static MappingJacksonValue convertToMjv(ErrorResponse error) {
        return new MappingJacksonValue(error);
    }

    @ExceptionHandler(TicketMalformedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MappingJacksonValue ticketMalformedHandler(TicketMalformedException exception) {
        ErrorResponse error =
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "There is something wrong with the given ticket data.",
                        exception.getMessage());
        logError(error);
        return convertToMjv(error);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MappingJacksonValue catchUnreadableRequest(HttpMessageConversionException exception) {
        ErrorResponse error =
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "The given request body can not be read because it has an incorrect format.",
                        exception.getMessage());
        logError(error);
        return convertToMjv(error);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MappingJacksonValue catchAllHandler(RuntimeException exception) {
        ErrorResponse error =
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "An unexpected error happened in the server. Please get in touch with us to solve this problem.",
                        exception.getMessage());
        logError(error);
        return convertToMjv(error);
    }
}
