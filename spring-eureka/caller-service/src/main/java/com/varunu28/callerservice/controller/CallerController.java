package com.varunu28.callerservice.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/caller")
public class CallerController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public CallerController(DiscoveryClient discoveryClient,
                            RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("/invoke")
    public String invoke() {
        ServiceInstance serviceInstance = discoveryClient.getInstances(
                "receiver-service").getFirst();
        return restClient.get()
                .uri(serviceInstance.getUri() + "/api/v1/receiver")
                .retrieve()
                .body(String.class);
    }
}
