package com.varunu28.springjpadomainevent.repository;

import com.varunu28.springjpadomainevent.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
