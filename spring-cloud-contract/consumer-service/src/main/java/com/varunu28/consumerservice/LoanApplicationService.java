package com.varunu28.consumerservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class LoanApplicationService {

    private final RestTemplate restTemplate;

    private int port = 8001;

    public LoanApplicationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String loanApplication(int amount, String clientId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        String url = "http://localhost:" + port + "/fraudcheck";
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setClientId(clientId);
        loanRequest.setLoanRequestAmount((long) amount);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(loanRequest, headers), String.class);
        return response.getBody();
    }

    public void setPort(int port) {
        this.port = port;
    }
}
