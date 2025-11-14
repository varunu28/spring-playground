package com.varunu28.springevents.events;

public record OrderCreatedEvent(String orderId, long amount) {}
