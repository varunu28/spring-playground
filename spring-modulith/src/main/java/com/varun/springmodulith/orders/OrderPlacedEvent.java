package com.varun.springmodulith.orders;

import org.springframework.modulith.events.Externalized;

@Externalized(target = AmqpIntegrationConfiguration.ORDERS_Q)
public record OrderPlacedEvent(Integer id) {
}
