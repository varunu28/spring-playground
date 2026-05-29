package io.varunu28.dbosdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String quote;

    private LocalDateTime created;

    private LocalDateTime deleted;

    public Quote() {
    }

    public Quote(String quote, LocalDateTime created) {
        this.quote = quote;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
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
