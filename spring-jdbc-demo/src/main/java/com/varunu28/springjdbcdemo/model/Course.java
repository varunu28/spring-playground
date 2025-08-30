package com.varunu28.springjdbcdemo.model;

import org.springframework.data.annotation.Id;

public class Course {

    private final String name;
    private final String description;
    @Id
    private Integer id;

    public Course(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
