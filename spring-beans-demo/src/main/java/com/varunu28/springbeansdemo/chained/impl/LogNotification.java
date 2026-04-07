package com.varunu28.springbeansdemo.chained.impl;

import com.varunu28.springbeansdemo.chained.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class LogNotification implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogNotification.class);

    @Override
    public void sendNotification() {
        LOGGER.info("notify through Logging");
    }
}
