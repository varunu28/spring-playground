package com.varunu28.springbeansdemo.service.impl;

import com.varunu28.springbeansdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail(String content, String toEmail) {
        LOGGER.info("Sending email to {}", toEmail);
    }
}
