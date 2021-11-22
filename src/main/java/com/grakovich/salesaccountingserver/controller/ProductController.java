package com.grakovich.salesaccountingserver.controller;

import com.grakovich.salesaccountingserver.model.Product;
import com.grakovich.salesaccountingserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/product")
    public boolean add(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/product/{id}")
    public Product get(@PathVariable Long id){
        return productService.findById(id);
    }

    @PutMapping("/product")
    public boolean update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
         productService.delete(id);
    }
}
