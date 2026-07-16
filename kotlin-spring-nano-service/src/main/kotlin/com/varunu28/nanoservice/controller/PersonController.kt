package com.varunu28.nanoservice.controller

import com.varunu28.nanoservice.repository.PersonRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(private val repository: PersonRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPerson(@RequestBody @Valid person: Person): Int {
        val newPerson = com.varunu28.nanoservice.repository.Person(
            name = person.name,
            age = person.age
        )
        val savedPerson = repository.save(newPerson)
        return savedPerson.id ?: 0
    }
}