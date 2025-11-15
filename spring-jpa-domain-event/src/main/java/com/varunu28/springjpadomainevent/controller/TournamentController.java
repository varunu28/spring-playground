package com.varunu28.springjpadomainevent.controller;

import com.varunu28.springjpadomainevent.service.TournamentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public Long createTournament(@RequestBody String description) {
        return tournamentService.createTournament(description);
    }

    @PutMapping("/{tournamentId}/end")
    public void endTournament(@PathVariable("tournamentId") Long tournamentId) {
        tournamentService.endTournament(tournamentId);
    }
}
