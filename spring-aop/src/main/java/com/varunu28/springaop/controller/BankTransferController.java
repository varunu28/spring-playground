package com.varunu28.springaop.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.varunu28.springaop.service.BankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank-transfer")
public class BankTransferController {

    private final BankService service;

    public BankTransferController(BankService service) {
        this.service = service;
    }

    @PostMapping
    public void transfer(@RequestBody TransferRequest request) {
        service.transfer(request.fromAccount, request.toAccount, request.amount);
    }

    public record TransferRequest(@JsonProperty("from_account") String fromAccount,
                           @JsonProperty("to_account") String toAccount,
                           @JsonProperty("amount") double amount) { }
}
