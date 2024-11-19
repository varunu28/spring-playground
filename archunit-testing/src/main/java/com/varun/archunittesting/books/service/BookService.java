package com.varun.archunittesting.books.service;

import com.varun.archunittesting.books.model.Book;
import com.varun.archunittesting.books.repository.BookRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getBookById(UUID id) {
        return bookRepository.getBookById(id);
    }

    public Book addBook(String name, UUID isbn, UUID authorId) {
        Book book = new Book(UUID.randomUUID(), name, authorId, isbn, 0);
        return bookRepository.addBook(book);
    }

    public Book updateBook(UUID id, String name, UUID isbn, UUID authorId) {
        Book book = new Book(id, name, authorId, isbn, 0);
        return bookRepository.updateBook(id, book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteBook(id);
    }
}
