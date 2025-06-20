package com.xpe.bootcamp.model.repositories.impl;

import com.xpe.bootcamp.model.domains.Product;
import com.xpe.bootcamp.model.repositories.ProductPersistenceRepository;
import com.xpe.bootcamp.model.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductPersistenceRepository persistenceRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return persistenceRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> findByName(String name) {
        return persistenceRepository.findByNameContaining(name);
    }

    @Override
    public Product save(Product product) {
        return persistenceRepository.save(product);
    }

    @Override
    public Optional<List<Product>> findAll() {
        return Optional.of(persistenceRepository.findAll());
    }

    @Override
    public boolean delete(Long id) {
        try {
            persistenceRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("An error occurred while trying to delete the product: {}", id, exception);
            return false;
        }
    }

    @Override
    public long count() {
        return persistenceRepository.count();
    }
}
