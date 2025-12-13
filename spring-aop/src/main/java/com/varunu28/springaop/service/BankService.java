package com.varunu28.springaop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankService.class);

    public BankService() {}

    public void transfer(String fromAccount, String toAccount, double amount) {
        LOGGER.info("Transferring " + amount + " from " + fromAccount + " to " + toAccount);
    }
}
