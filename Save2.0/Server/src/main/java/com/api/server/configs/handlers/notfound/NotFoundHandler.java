package com.api.server.configs.handlers.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class NotFoundHandler {

    @ExceptionHandler(value = NotFoundException.class)
    ResponseEntity<NotFound> handleNotFoundException(NotFoundException e) {
        HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;

        NotFound notFound =  new NotFound(
                e.getMessage(),
                notFoundStatus,
                ZonedDateTime.now(ZoneId.of("UTC"))
        );

        return new ResponseEntity<>(notFound, notFoundStatus);
    }

}
