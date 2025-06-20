package com.xpe.bootcamp.model.services;

import com.xpe.bootcamp.model.domains.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    List<Product> findByName(String name);
    Product save(Product product);
    Product update(Product product);
    boolean delete(Long id);
    long count();
}
