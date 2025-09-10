package com.varunu28.springbeansdemo;

import com.varunu28.springbeansdemo.service.EmailService;
import com.varunu28.springbeansdemo.service.EvenNumberGenerator;
import com.varunu28.springbeansdemo.service.OddNumberGenerator;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@SpringBootApplication
public class SpringBeansDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeansDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner injectingSameBeanForMultipleInterfaces(EvenNumberGenerator evenNumberGenerator,
        OddNumberGenerator oddNumberGenerator) {
        System.out.println("Generating even number: " + evenNumberGenerator.generateEvenNumber());
        System.out.println("Generating odd number: " + oddNumberGenerator.generateOddNumber());
        return args -> {};
    }

    // Expected dummy bean to be injected as we specify the parameter name to be equal to the bean name.
    // This is equivalent to @Qualifier("dummyEmailService")
    @Bean
    public CommandLineRunner injectionThroughNamedParameter(EmailService dummyEmailService) {
        dummyEmailService.sendEmail("content", "toEmail");
        return args -> {};
    }

    // Expected emailService bean to be injected as we specify the qualifier annotation. So the ObjectProvider will
    // consist of emailService bean.
    @Bean
    public CommandLineRunner injectionThroughObjectProviderWithQualifier(
        @Qualifier("emailService") ObjectProvider<EmailService> emailServiceProvider) {
        EmailService emailService = emailServiceProvider.getObject();
        emailService.sendEmail("content", "toEmail");
        return args -> {};
    }

    // This is a conditional bean injection. If the config.email.enabled property is set to true, then the bean will be
    // injected. Otherwise, it will be null.
    @Bean
    public CommandLineRunner conditionalBeanInjection(
        @Qualifier("conditionalEmailService") ObjectProvider<EmailService> conditionalEmailServiceProvider) {
        EmailService ifAvailable = conditionalEmailServiceProvider.getIfAvailable();
        if (ifAvailable != null) {
            ifAvailable.sendEmail("content", "toEmail");
        }
        return args -> {};
    }
}

