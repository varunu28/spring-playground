package com.varunu28.springjpadomainevent.model;

import java.time.LocalDate;

public record TournamentStartEvent(Long tournamentId, LocalDate startDate) {
}
