package com.varunu28.springevents.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.varunu28.springevents.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createOrder(@RequestBody CreateOrderRequest request) {
        orderService.createOrder(request.orderId(), request.amount());
        return "Order placed successfully for ID: " + request.orderId();
    }

    public record CreateOrderRequest(@JsonProperty("order_id") String orderId, @JsonProperty("amount") long amount) {}
}
