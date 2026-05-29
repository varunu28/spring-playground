package io.varunu28.dbosdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderWorkflow orderWorkflow;

    public OrderController(OrderWorkflow orderWorkflow) {
        this.orderWorkflow = orderWorkflow;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody CreateOrderDto request) {
        return orderWorkflow.createThroughSaga(request.description(), request.amount());
    }
}
