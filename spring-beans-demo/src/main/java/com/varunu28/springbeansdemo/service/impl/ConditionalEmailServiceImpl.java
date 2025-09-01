package com.varunu28.springbeansdemo.service.impl;

import com.varunu28.springbeansdemo.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This service is conditionally loaded based on the value of the "config.email.enabled" property.
 */
public class ConditionalEmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionalEmailServiceImpl.class);

    @Override
    public void sendEmail(String content, String toEmail) {
        LOGGER.info("Conditionally sending email to {}", toEmail);
    }
}
