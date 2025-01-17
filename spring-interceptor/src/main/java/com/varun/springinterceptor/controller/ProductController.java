package com.varun.springinterceptor.controller;

import com.varun.springinterceptor.model.Product;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/products",
    produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    @GetMapping(value = "/list")
    public List<Product> getProducts() {
        LOGGER.info("ProductController::getProducts()");

        return List.of(
            new Product(1L, "Laptop", 1000.0),
            new Product(2L, "Mobile", 500.0),
            new Product(3L, "Tablet", 300.0)
        );
    }

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody Product product) {
        LOGGER.info("ProductController::addProduct()");

        return product;
    }
}
