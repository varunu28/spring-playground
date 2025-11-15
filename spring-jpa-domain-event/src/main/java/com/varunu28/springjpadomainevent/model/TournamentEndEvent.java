package com.varunu28.springjpadomainevent.model;

import java.time.LocalDate;

public record TournamentEndEvent(Long tournamentId, LocalDate endDate) {}
