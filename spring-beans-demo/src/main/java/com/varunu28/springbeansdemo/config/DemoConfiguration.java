package com.varunu28.springbeansdemo.config;

import com.varunu28.springbeansdemo.service.EmailService;
import com.varunu28.springbeansdemo.service.impl.ConditionalEmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean("conditionalEmailService")
    @Conditional(EmailServiceBeanCondition.class)
    public EmailService emailService() {
        return new ConditionalEmailServiceImpl();
    }
}
