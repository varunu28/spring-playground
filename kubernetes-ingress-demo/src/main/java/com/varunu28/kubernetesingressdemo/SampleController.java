package com.varunu28.kubernetesingressdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleController {

    @GetMapping
    public String sample() {
        return "Hello from Kubernetes Ingress Demo!";
    }
}
