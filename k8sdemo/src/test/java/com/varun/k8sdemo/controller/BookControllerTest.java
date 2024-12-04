package com.varun.k8sdemo.controller;

import com.varun.k8sdemo.exception.BookNotFoundException;
import com.varun.k8sdemo.model.Book;
import com.varun.k8sdemo.repository.BookRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1, "Test Book", UUID.randomUUID(), 1);
    }

    @Test
    void getBookById() throws Exception {
        when(bookRepository.getBookById(1)).thenReturn(book);

        mockMvc.perform(get("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                    {
                        "id": 1,
                        "name": "Test Book",
                        "isbn": "%s",
                        "authorId": 1
                    }
                """.formatted(book.isbn().toString())));
    }

    @Test
    void getBookById_notFound() throws Exception {
        when(bookRepository.getBookById(1)).thenThrow(new BookNotFoundException(1));

        mockMvc.perform(get("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    void addBook() throws Exception {
        when(bookRepository.addBook(book)).thenReturn(book);

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "id": 1,
                        "name": "Test Book",
                        "isbn": "%s",
                        "authorId": 1
                    }
                """.formatted(book.isbn().toString())))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                    "id": 1,
                    "name": "Test Book",
                    "isbn": "%s",
                    "authorId": 1
                }
            """.formatted(book.isbn().toString())));
    }

    @Test
    void getAllBooks() throws Exception {
        when(bookRepository.getAllBooks()).thenReturn(List.of(book));

        mockMvc.perform(get("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                [{
                    "id": 1,
                    "name": "Test Book",
                    "isbn": "%s",
                    "authorId": 1
                }]
            """.formatted(book.isbn().toString())));
    }

    @Test
    void deleteBook() throws Exception {
        doNothing().when(bookRepository).deleteBook(1);

        mockMvc.perform(delete("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }

    @Test
    void updateBook() throws Exception {
        when(bookRepository.updateBook(1, book)).thenReturn(book);

        mockMvc.perform(put("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "id": 1,
                        "name": "Test Book",
                        "isbn": "%s",
                        "authorId": 1
                    }
                """.formatted(book.isbn().toString())))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                    "id": 1,
                    "name": "Test Book",
                    "isbn": "%s",
                    "authorId": 1
                }
            """.formatted(book.isbn().toString())));
    }

    @Test
    void updateBook_notFound() throws Exception {
        when(bookRepository.updateBook(1, book)).thenThrow(new BookNotFoundException(1));

        mockMvc.perform(put("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "id": 1,
                        "name": "Test Book",
                        "isbn": "%s",
                        "authorId": 1
                    }
                """.formatted(book.isbn().toString())))
            .andExpect(status().isNotFound());
    }
}
