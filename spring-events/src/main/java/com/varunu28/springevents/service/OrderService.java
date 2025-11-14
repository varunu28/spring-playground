package com.varunu28.springevents.service;

import com.varunu28.springevents.events.OrderCreatedEvent;
import java.util.logging.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void createOrder(String orderId, long amount) {
        // Logic to create an order
        LOGGER.info("Order created with ID: " + orderId);
        publisher.publishEvent(new OrderCreatedEvent(orderId, amount));
    }
}
