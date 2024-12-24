package com.varun.springactuator;

import org.springframework.boot.SpringApplication;

public class TestSpringActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringActuatorApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
