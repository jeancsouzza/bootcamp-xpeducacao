package com.xpe.bootcamp.model.repositories;

import com.xpe.bootcamp.model.domains.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Optional<List<Product>> findByName(String name);
    Product save(Product product);
    Optional<List<Product>> findAll();
    boolean delete(Long id);
    long count();
}
