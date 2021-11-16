package com.grakovich.salesaccountingserver.controller;

import com.grakovich.salesaccountingserver.model.Supplier;
import com.grakovich.salesaccountingserver.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    private List<Supplier> getAll(){
        return supplierService.getAll();
    }

    @PostMapping("/supplier")
    public boolean add(@RequestBody Supplier supplier){
        return supplierService.add(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    public void delete(@PathVariable Long id){
        supplierService.delete(id);
    }
}
