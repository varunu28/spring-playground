package com.varunu28.springbeansdemo.chained.impl;

import com.varunu28.springbeansdemo.chained.NotificationService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PushNotification implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("notify using push notification");
    }
}
