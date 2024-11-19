package com.varun.archunittesting.books.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book with given id not found");
    }
}
