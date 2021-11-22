package com.grakovich.salesaccountingserver.service;

import com.grakovich.salesaccountingserver.model.Order;
import com.grakovich.salesaccountingserver.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public void save(Order order) {
        orderRepo.save(order);
    }
}
