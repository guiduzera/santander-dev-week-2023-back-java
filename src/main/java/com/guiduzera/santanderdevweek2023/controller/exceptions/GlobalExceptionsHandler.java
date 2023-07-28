package com.guiduzera.santanderdevweek2023.controller.exceptions;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Usário não encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleBadRequest(RuntimeException badRequestException) {
        return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleInternalError(Throwable unexpectedException) {
        logger.error("Erro interno no servidor", unexpectedException);
        return new ResponseEntity<>("Erro interno no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
