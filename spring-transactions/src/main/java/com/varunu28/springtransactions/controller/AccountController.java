package com.varunu28.springtransactions.controller;

import com.varunu28.springtransactions.model.Account;
import com.varunu28.springtransactions.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Long> createAccount(@RequestBody String name) {
        Long id = accountService.createAccount(name);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestBody DepositRequest depositRequest) {
        Account account = accountService.getAccountById(depositRequest.accountId());
        accountService.deposit(depositRequest.amount, account);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferRequest transferRequest) {
        accountService.transfer(transferRequest.amount, transferRequest.senderId, transferRequest.receiverId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<Double> getBalance(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account.getBalance());
    }

    public record DepositRequest(Double amount, Long accountId) { }

    public record TransferRequest(Double amount, Long senderId, Long receiverId) { }
}
