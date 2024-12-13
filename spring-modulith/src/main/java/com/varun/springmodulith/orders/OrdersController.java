package com.varun.springmodulith.orders;

import java.util.Set;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    void placeOrder(@RequestBody Order order) {
        orderService.place(order);
    }
}

@Service
@Transactional
class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderService(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    void place(Order order) {
        var saved = orderRepository.save(order);
        System.out.println("Order placed: " + saved);

        this.eventPublisher.publishEvent(new OrderPlacedEvent(saved.id()));
    }
}

@Configuration
class AmqpIntegrationConfiguration {

    static final String ORDERS_Q = "orders";

    @Bean Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDERS_Q).noargs();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(ORDERS_Q).build();
    }

    @Bean Exchange exchange() {
        return ExchangeBuilder.directExchange(ORDERS_Q).build();
    }
}

@Repository
interface OrderRepository extends ListCrudRepository<Order, Integer> {}

@Table("orders_line_items")
record LineItem(@Id Integer id, int product, int quantity) {}

@Table("orders")
record Order(@Id Integer id, Set<LineItem> lineItems) {}