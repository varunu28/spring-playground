package com.varunu28.springevents.listeners;

import com.varunu28.springevents.events.OrderCreatedEvent;
import java.util.logging.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    private static final Logger LOGGER = Logger.getLogger(EmailNotificationListener.class.getName());

    @EventListener
    @Async
    @Order(1)
    public void handleOrderCreatedEvent(OrderCreatedEvent event) throws InterruptedException {
        LOGGER.info("Sending email notification for order ID: " + event.orderId());
        Thread.sleep(5000); // Simulate delay in sending email
        LOGGER.info("Email notification sent for order ID: " + event.orderId());
    }
}
