package com.educandoweb.workshop.resources.exceptions;

import com.educandoweb.workshop.services.exceptions.DatabaseException;
import com.educandoweb.workshop.services.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.time.Instant.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> database(ResourceNotFoundException ex, HttpServletRequest request) {
        log.info("O ID não foi encontrado");
        String error = "Resource Not Found";
        HttpStatus status = NOT_FOUND;
        StandardError err = new StandardError(now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException ex, HttpServletRequest request) {
        log.info("Erro no banco de dados");
        String error = "Database Error";
        HttpStatus status = BAD_REQUEST;
        StandardError err = new StandardError(now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
