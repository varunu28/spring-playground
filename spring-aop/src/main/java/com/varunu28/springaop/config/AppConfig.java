package com.varunu28.springaop.config;

import com.varunu28.springaop.aspect.BankTransferAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BankTransferAspect bankTransferAspect() {
        return new BankTransferAspect();
    }
}
