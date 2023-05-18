package com.api.server.configs.handlers.notfound;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record NotFound(String message, HttpStatus status, ZonedDateTime timestamp) {
}
