package io.varunu28.dbosdemo;

import dev.dbos.transact.workflow.Step;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This is a toy implementation to play around with DBOS. In real world scenario all the JPA specific code can be
 * wrapped in a single {@link Transactional} block as we are working in a single database. In a real scenario these
 * individual persistence operations will be separate service calls which can fail due to multiple reasons while
 * communicating over the network.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final QuoteRepository quoteRepository;
    private final RestClient restClient;

    public OrderService(OrderRepository orderRepository, QuoteRepository quoteRepository, RestClient restClient) {
        this.orderRepository = orderRepository;
        this.quoteRepository = quoteRepository;
        this.restClient = restClient;
    }

    @Step
    public String queryQuote() {
        try {
            KanyeQuote response = restClient.get().retrieve().body(KanyeQuote.class);
            return Objects.requireNonNull(response).quote();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step
    @Transactional
    public Quote persistQuote(final String quoteString) {
        Quote quote = new Quote(quoteString, LocalDateTime.now());
        return quoteRepository.save(quote);
    }

    @Step
    @Transactional
    public void deleteQuote(Quote quote) {
        quote.setDeleted(LocalDateTime.now());
        quoteRepository.save(quote);
    }

    @Step
    @Transactional
    public Order persistOrder(final String description, final int amount, final String quote) {
        Order order = new Order(description, amount, quote, LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Step
    @Transactional
    public void deleteOrder(Order order) {
        order.setDeleted(LocalDateTime.now());
        orderRepository.save(order);
    }

    public record KanyeQuote(String quote) {}
}
