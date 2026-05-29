package io.varunu28.dbosdemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String description;

    private int count;

    private String quote;

    private LocalDateTime created;

    private LocalDateTime deleted;

    public Order() {
    }

    public Order(String description, int count, String quote, LocalDateTime created) {
        this.description = description;
        this.count = count;
        this.quote = quote;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(final String quote) {
        this.quote = quote;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(final LocalDateTime deleted) {
        this.deleted = deleted;
    }
}
