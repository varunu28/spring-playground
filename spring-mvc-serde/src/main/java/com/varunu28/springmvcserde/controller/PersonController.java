package com.varunu28.springmvcserde.controller;

import com.varunu28.springmvcserde.model.Person;
import com.varunu28.springmvcserde.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable long id) {
        Optional<Person> person = personService.getById(id);
        return person.orElse(null);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }
}
