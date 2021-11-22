package com.grakovich.salesaccountingserver.controller;

import com.grakovich.salesaccountingserver.model.Order;
import com.grakovich.salesaccountingserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @PostMapping("/order")
    public boolean add(@RequestBody Order order){
        orderService.save(order);
        return true;
    }
}
