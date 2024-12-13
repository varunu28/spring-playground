package com.varun.springmvc.typeconversion.controller;

import com.varun.springmvc.typeconversion.model.NestedInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class TypeConversionDemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value = "nestedInput") NestedInput nestedInput) {
        String output = nestedInput.getToken() +
            nestedInput.getMoreNestedInput().getIdOne() +
            nestedInput.getMoreNestedInput().getIdTwo() +
            nestedInput.getMoreNestedInput().getIdThree();
        return ResponseEntity.ok("Hello World! " + output);
    }
}
