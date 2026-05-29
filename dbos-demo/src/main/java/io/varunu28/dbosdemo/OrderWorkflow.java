package io.varunu28.dbosdemo;

import dev.dbos.transact.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderWorkflow {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWorkflow.class);

    private final OrderService orderService;

    public OrderWorkflow(OrderService orderService) {
        this.orderService = orderService;
    }

    @Workflow
    public Order createThroughSaga(String description, int amount) {
        String queriedQuote;
        Quote persistedQuote = null;
        Order persistedOrder = null;

        try {
            queriedQuote = orderService.queryQuote();
            persistedQuote = orderService.persistQuote(queriedQuote);
            persistedOrder = orderService.persistOrder(description, amount, queriedQuote);
            return persistedOrder;
        } catch (Exception e) {
            LOGGER.error("Exception occurred during order creation", e);
            if (persistedQuote != null) {
                orderService.deleteQuote(persistedQuote);
            }
            // persistedOrder can be null if the application goes down after persisting the order but before returning
            // the response.
            if (persistedOrder != null) {
                orderService.deleteOrder(persistedOrder);
            }
            throw new OrderCreationFailedException(e.getMessage());
        }
    }
}
