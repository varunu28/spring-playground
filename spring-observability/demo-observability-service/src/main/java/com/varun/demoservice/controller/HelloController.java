package com.varun.demoservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private static final String EXTERNAL_SERVICE_URL = "https://httpbin.org/post";

    private final RestTemplate restTemplate;

    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String hello() {
        ResponseEntity<String> responseEntity =
            restTemplate.postForEntity(EXTERNAL_SERVICE_URL, "Hello, World", String.class);
        return responseEntity.getBody();
    }
}
