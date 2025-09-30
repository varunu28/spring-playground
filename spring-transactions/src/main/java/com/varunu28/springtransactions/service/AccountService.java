package com.varunu28.springtransactions.service;

import com.varunu28.springtransactions.model.Account;
import com.varunu28.springtransactions.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Spring Transaction: AOP
    // Around advice i.e., before and after method invocation
    // Before: Create or get a transaction
    // transfer() method is invoked in a transaction
    // After: Commit or rollback the transaction in case of a failure
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(double amount, Long senderAccountId, Long receiverAccountId) {
        Account sender = getAccountById(senderAccountId);
        Account receiver = getAccountById(receiverAccountId);

        sender.setBalance(sender.getBalance() - amount);
        accountRepository.save(sender);

        injectError();

        receiver.setBalance(receiver.getBalance() + amount);
        accountRepository.save(receiver);
    }

    private void injectError() {
        throw new RuntimeException("injected error");
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("account not found"));
    }

    public Long createAccount(String name) {
        Account account = new Account(name);
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getId();
    }

    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
