package com.varunu28.springmvcserde.service;

import com.varunu28.springmvcserde.model.Person;
import com.varunu28.springmvcserde.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public Optional<Person> getById(long id) {
        return personRepository.getById(id);
    }
}
