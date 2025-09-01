package com.varunu28.springbeansdemo.service.impl;

import com.varunu28.springbeansdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("dummyEmailService")
public class DummyEmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DummyEmailServiceImpl.class);

    @Override
    public void sendEmail(String content, String toEmail) {
        LOGGER.info("Dummy act to send email to {}", toEmail);
    }
}
