package com.varunu28.springevents.listeners;

import com.varunu28.springevents.events.OrderCreatedEvent;
import java.util.logging.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LoggingListener {

    private static final Logger LOGGER = Logger.getLogger(LoggingListener.class.getName());

    @EventListener
    @Async
    @Order(2)
    public void logOrderCreation(OrderCreatedEvent event) {
        LOGGER.info("Logging order creation with ID: " + event.orderId());
    }
}
