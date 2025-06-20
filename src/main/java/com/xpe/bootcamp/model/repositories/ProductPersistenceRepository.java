package com.xpe.bootcamp.model.repositories;

import com.xpe.bootcamp.model.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductPersistenceRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findByNameContaining(String name);
}
