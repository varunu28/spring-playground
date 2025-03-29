package com.varunu28.callerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/caller")
public class CallerController {

    private static final String RECEIVER_ENDPOINT = "/api/v1/receiver";

    private final RestClient restClient;

    public CallerController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/invoke")
    public String invoke() {
        return restClient.get()
                .uri("http://receiver-service" + RECEIVER_ENDPOINT)
                .retrieve()
                .body(String.class);
    }
}
