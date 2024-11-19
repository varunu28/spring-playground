package com.varun.archunittesting.books.model;

import java.util.UUID;

public record AddBookRequest(String name, UUID isbn, UUID authorId) {
}
