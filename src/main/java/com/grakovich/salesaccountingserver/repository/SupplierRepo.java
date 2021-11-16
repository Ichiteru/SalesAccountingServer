package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    public boolean existsByName(String name);
}
