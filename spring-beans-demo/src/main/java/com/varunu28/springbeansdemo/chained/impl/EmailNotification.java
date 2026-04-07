package com.varunu28.springbeansdemo.chained.impl;

import com.varunu28.springbeansdemo.chained.NotificationService;
import com.varunu28.springbeansdemo.config.EmailServiceBeanCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Conditional(EmailServiceBeanCondition.class)
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("notify using email");
    }
}
