package com.api.server.configs.handlers.badrequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class BadRequestHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<BadRequest> handleBadRequestException(BadRequestException e) {
        HttpStatus badRequestStatus = HttpStatus.BAD_REQUEST;

        BadRequest badRequest = new BadRequest(
                e.getMessage(),
                badRequestStatus,
                ZonedDateTime.now(ZoneId.of("UTC"))
        );
        return new ResponseEntity<>(badRequest, badRequestStatus);
    }

}
