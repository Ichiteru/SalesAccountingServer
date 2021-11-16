package com.grakovich.salesaccountingserver.controller;

import com.grakovich.salesaccountingserver.model.ProductType;
import com.grakovich.salesaccountingserver.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/productTypes")
    public List<ProductType> getAll(){
        return productTypeService.getAll();
    }

    @PostMapping("/productType")
    public boolean add(@RequestBody ProductType productName){
        return productTypeService.add(productName);
    }

    @DeleteMapping("/productType/{id}")
    public void delete(@PathVariable Long id){
        productTypeService.delete(id);
    }
}
