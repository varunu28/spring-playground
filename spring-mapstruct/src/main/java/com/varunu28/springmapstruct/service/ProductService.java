package com.varunu28.springmapstruct.service;

import com.varunu28.springmapstruct.dto.ProductResponse;
import com.varunu28.springmapstruct.model.Product;
import com.varunu28.springmapstruct.model.ProductMapper;
import com.varunu28.springmapstruct.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Long createProduct(String name, String description) {
        Product product = new Product(name, description);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.mapProductToProductResponse(product);
    }
}
