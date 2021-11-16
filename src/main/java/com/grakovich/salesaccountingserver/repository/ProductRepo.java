package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    public Optional<Product> findByModel(String model);
    public boolean existsByModel(String model);
}
