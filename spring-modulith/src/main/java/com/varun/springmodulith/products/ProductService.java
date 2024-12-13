package com.varun.springmodulith.products;

import com.varun.springmodulith.orders.OrderPlacedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @ApplicationModuleListener
    void onOrderPlaced(OrderPlacedEvent event) throws InterruptedException {
        System.out.println("Starting to process order: " + event.id());
        Thread.sleep(5_000);
        System.out.println("Order processed: " + event.id());
    }
}
