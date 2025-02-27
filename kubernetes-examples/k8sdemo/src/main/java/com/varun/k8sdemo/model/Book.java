package com.varun.k8sdemo.model;

import java.util.UUID;

public record Book(Integer id, String name, UUID isbn, Integer authorId) {
}
