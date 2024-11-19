package com.varun.archunittesting.books.controller;

import com.varun.archunittesting.books.model.AddBookRequest;
import com.varun.archunittesting.books.model.Book;
import com.varun.archunittesting.books.service.BookService;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody AddBookRequest request) {
        return bookService.addBook(request.name(), request.isbn(), request.authorId());
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody AddBookRequest request) {
        return bookService.updateBook(id, request.name(), request.isbn(), request.authorId());
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }
}
