package com.varunu28.kotlindsltest.conference;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/conference", produces = APPLICATION_JSON_VALUE)
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(final ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createConference(@RequestBody @Valid CreateConferenceDto createConferenceDto) {
        return conferenceService.addConference(createConferenceDto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conference getConference(@PathVariable UUID id) {
        return conferenceService.getConference(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Conference> getConferences() {
        return conferenceService.listAllConferences();
    }
}
