package com.varun.springmvc.formencoded.controller;

import com.varun.springmvc.formencoded.dto.CreateAccountRequest;
import com.varun.springmvc.formencoded.dto.UpdateLastNameRequest;
import com.varun.springmvc.formencoded.service.InMemoryService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/formencoded", produces = APPLICATION_JSON_VALUE)
public class FormEncodedDemoController {

    private final InMemoryService service;

    public FormEncodedDemoController(InMemoryService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<UUID> createAccount(@ModelAttribute CreateAccountRequest request) {
        UUID uuid = service.saveEmployee(request.firstName(), request.lastName());
        return ResponseEntity.ok(uuid);
    }

    @PutMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> updateLastName(@ModelAttribute UpdateLastNameRequest request) {
        service.updateLastName(request.id(), request.lastName());
        return ResponseEntity.ok().build();
    }
}
