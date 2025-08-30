package com.varunu28.springjdbcdemo.advice;

import com.varunu28.springjdbcdemo.exception.EnrollmentDataIntegrityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EnrollmentControllerAdvice {

    @ExceptionHandler(EnrollmentDataIntegrityException.class)
    public ResponseEntity<String> handleEnrollmentDataIntegrityException(EnrollmentDataIntegrityException ex) {
        return ResponseEntity.badRequest().body("Failed to enroll. Make sure the student and course exist.");
    }
}
