package com.varun.archunittesting.books.model;

import java.util.UUID;

public record Book(UUID id, String name, UUID authorId, UUID isbn, Integer rating) {
}
