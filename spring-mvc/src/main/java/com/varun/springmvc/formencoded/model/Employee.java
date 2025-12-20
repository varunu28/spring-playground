package com.varun.springmvc.formencoded.model;

import java.time.Instant;
import java.util.UUID;

public class Employee {

    private final UUID uuid;
    private final String firstName;
    private String lastName;
    private final Instant createdAt;

    public Employee(String firstName, String lastName) {
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = Instant.now();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
