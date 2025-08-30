package com.varunu28.springjdbcdemo;

import org.springframework.boot.SpringApplication;

public class TestSpringJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringJdbcDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
