package com.varunu28.springjdbcdemo.exception;

public class CourseNotFoundException extends Throwable {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
