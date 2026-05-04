package com.varunu28.kotlindsltest.conference;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ConferenceService {

    private final Map<UUID, Conference> conferences;

    public ConferenceService() {
        this.conferences = new HashMap<>();
    }

    public Conference getConference(final UUID uuid) {
        if (!conferences.containsKey(uuid)) {
            throw new ConferenceNotFoundException();
        }
        return conferences.get(uuid);
    }

    public UUID addConference(CreateConferenceDto createConferenceDto) {
        Conference conference = new Conference(
                createConferenceDto.name(),
                createConferenceDto.description(),
                createConferenceDto.startDate(),
                createConferenceDto.endDate());
        UUID id = UUID.randomUUID();
        conferences.put(id, conference);
        return id;
    }

    public List<Conference> listAllConferences() {
        return List.copyOf(conferences.values());
    }
}
