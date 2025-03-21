package com.varunu28.receiverservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/receiver")
public class ReceiverController {

    @GetMapping
    public String getMessage() {
        return "Hello from Receiver Service";
    }
}
