package com.varunu28.producerservice;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class FraudController {

    @PutMapping(
            value = "/fraudcheck", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String check(@RequestBody LoanRequest loanRequest) {

        if (loanRequest.getLoanAmount() > 10000) {
            return "{fraudCheckStatus: FRAUD, rejection.reason: Amount too high}";
        } else {
            return "{fraudCheckStatus: OK, acceptance.reason: Amount OK}";
        }
    }
}

