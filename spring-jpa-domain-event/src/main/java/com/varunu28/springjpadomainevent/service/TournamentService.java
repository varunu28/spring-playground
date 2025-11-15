package com.varunu28.springjpadomainevent.service;

import com.varunu28.springjpadomainevent.model.Tournament;
import com.varunu28.springjpadomainevent.repository.TournamentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Long createTournament(String description) {
        var tournament = new Tournament(description);
        Tournament save = tournamentRepository.saveAndFlush(tournament);
        // Start the tournament which registers the start event
        save.startTournament();
        // Save again so that the domain event is published
        tournamentRepository.save(save);
        return save.getId();
    }

    public void endTournament(Long tournamentId) {
        var tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new IllegalArgumentException("Tournament not found with ID: " + tournamentId));
        tournament.endTournament();
        tournamentRepository.save(tournament);
    }
}
