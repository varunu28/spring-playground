package com.varun.k8sdemo.repository;

import com.varun.k8sdemo.exception.BookNotFoundException;
import com.varun.k8sdemo.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }

    public Book getBookById(int id) throws BookNotFoundException {
        return books.stream()
            .filter(book -> book.id() == id)
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.id() == id);
    }

    public Book updateBook(int id, Book book) throws BookNotFoundException {
        Book bookToUpdate = getBookById(id);
        books.remove(bookToUpdate);
        books.add(book);
        return book;
    }
}
