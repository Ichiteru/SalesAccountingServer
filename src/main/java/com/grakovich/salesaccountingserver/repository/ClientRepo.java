package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Boolean existsByEmail(String email);
}
