package com.varunu28.springmvcserde.repository;

import com.varunu28.springmvcserde.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {

    private final List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
        initData();
    }

    public List<Person> getAll() {
        return Collections.unmodifiableList(people);
    }

    public Optional<Person> getById(long id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    private void initData() {
        this.people.add(new Person(1, "John", "Doe",
                new Date()));
        this.people.add(new Person(2, "Jane", "Smith",
                new Date()));
        this.people.add(new Person(3, "Alice", null,
                new Date()));
    }
}
