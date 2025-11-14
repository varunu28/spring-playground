package com.varunu28.springevents.listeners;

import com.varunu28.springevents.events.OrderCreatedEvent;
import java.util.logging.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LargeOrderTransactionListener {

    private static final Logger LOGGER = Logger.getLogger(LargeOrderTransactionListener.class.getName());

    @EventListener(condition = "#event.amount > 1000")
    public void largeTransactionAlert(OrderCreatedEvent event) {
        LOGGER.info("Large order has been created with ID: " + event.orderId() + " and amount: " + event.amount());
    }
}
