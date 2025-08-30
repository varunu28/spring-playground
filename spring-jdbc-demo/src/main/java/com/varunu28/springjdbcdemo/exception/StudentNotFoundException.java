package com.varunu28.springjdbcdemo.exception;

public class StudentNotFoundException extends Throwable {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
