package com.xpe.bootcamp.model.services.impl;

import com.xpe.bootcamp.model.domains.Product;
import com.xpe.bootcamp.model.repositories.ProductRepository;
import com.xpe.bootcamp.model.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().orElse(Collections.emptyList());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found to id: " + id
            ));
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found to name: " + name
            ));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        productRepository.findById(product.getId())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                    "An error occurred while trying to update. Product not found to code: " + product.getId()
                ));

        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "An error occurred while trying to delete. Product not found to ID: " + id
                ));

        return productRepository.delete(product.getId());
    }

    @Override
    public long count() {
        return productRepository.count();
    }
}
