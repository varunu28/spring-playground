package com.varun.k8sdemo.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(int id) {
        super("Book not found with id: " + id);
    }
}
