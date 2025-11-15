package com.varunu28.springjpadomainevent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "tournaments")
public class Tournament extends AbstractAggregateRoot<Tournament> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    public Tournament() {
    }

    public Tournament(String description) {
        this.description = description;
        this.startDate = LocalDate.now();
    }

    public void startTournament() {
        registerEvent(new TournamentStartEvent(id, startDate));
    }

    public void endTournament() {
        endDate = LocalDate.now();
        registerEvent(new TournamentEndEvent(id, endDate));
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
