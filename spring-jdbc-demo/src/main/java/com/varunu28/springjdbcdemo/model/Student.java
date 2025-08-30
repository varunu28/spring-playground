package com.varunu28.springjdbcdemo.model;

import org.springframework.data.annotation.Id;

public class Student {

    private final String name;
    @Id
    private Integer id;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
