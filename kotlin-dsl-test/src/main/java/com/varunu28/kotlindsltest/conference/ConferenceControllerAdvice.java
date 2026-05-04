package com.varunu28.kotlindsltest.conference;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@ControllerAdvice
public class ConferenceControllerAdvice {

    @ExceptionHandler(ConferenceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(ConferenceNotFoundException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(Map.of("message", "Invalid conference ID format"), HttpStatus.BAD_REQUEST);
    }
}
