package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {

    public boolean existsByName(String name);
}
