package com.varun.springactuator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "products")
public class Product {

    @Id
    private Long id;

    private String name;

    private double price;

    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
