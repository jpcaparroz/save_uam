package com.api.server.configs.handlers.badrequest;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record BadRequest(String message, HttpStatus status, ZonedDateTime timestamp) {
}
