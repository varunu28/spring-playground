package com.varunu28.jmsactivemq;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsClient;
import org.springframework.stereotype.Component;

import static com.varunu28.jmsactivemq.JmsActivemqApplication.QUEUE_NAME;

@SpringBootApplication
public class JmsActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsActivemqApplication.class, args);
    }

    static final String QUEUE_NAME = "test.queue";
}

@Component
class MessageConsumer {

    @JmsListener(destination = QUEUE_NAME)
    void onMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

@Component
class MessageProducer implements ApplicationRunner {

    private final JmsClient jmsClient;

    MessageProducer(JmsClient jmsClient) {
        this.jmsClient = jmsClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jmsClient.destination(QUEUE_NAME).send("Hello World!");
    }
}
