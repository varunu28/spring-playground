package com.varunu28.springbeansdemo.config;

import com.varunu28.springbeansdemo.service.EvenNumberGenerator;
import com.varunu28.springbeansdemo.service.OddNumberGenerator;
import com.varunu28.springbeansdemo.service.impl.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberGeneratorConfiguration {

    @Bean
    NumberGeneratorImpl numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public EvenNumberGenerator evenNumberGenerator() {
        return numberGenerator();
    }

    @Bean
    public OddNumberGenerator oddNumberGenerator() {
        return numberGenerator();
    }
}
