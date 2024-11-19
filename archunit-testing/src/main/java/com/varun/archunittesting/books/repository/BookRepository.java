package com.varun.archunittesting.books.repository;

import com.varun.archunittesting.books.model.Book;
import com.varun.archunittesting.books.exception.BookNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public final List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public Book getBookById(UUID id) {
        return books.stream()
            .filter(book -> book.id().equals(id))
            .findFirst()
            .orElseThrow(BookNotFoundException::new);
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(UUID id, Book book) {
        Book existingBook = getBookById(id);
        books.remove(existingBook);
        books.add(book);
        return book;
    }

    public void deleteBook(UUID id) {
        Book existingBook = getBookById(id);
        books.remove(existingBook);
    }
}
