package com.varunu28.springmapstruct.repository;

import com.varunu28.springmapstruct.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
