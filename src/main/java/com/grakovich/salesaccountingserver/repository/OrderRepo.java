package com.grakovich.salesaccountingserver.repository;

import com.grakovich.salesaccountingserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
