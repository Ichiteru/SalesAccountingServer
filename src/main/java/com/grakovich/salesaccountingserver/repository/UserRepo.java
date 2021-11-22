package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public Optional<User> findByUsernameAndPassword(String username, String password);
    public Optional<User> findByUsername(String username);
    public boolean existsByUsername(String username);
}
