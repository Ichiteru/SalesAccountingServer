package com.grakovich.salesaccountingserver.service;

import com.grakovich.salesaccountingserver.model.ProductType;
import com.grakovich.salesaccountingserver.repository.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepo productTypeRepo;

    public List<ProductType> getAll() {
        return productTypeRepo.findAll();
    }

    public boolean add(ProductType productName) {
        if (!productTypeRepo.existsByName(productName.getName())){
            productTypeRepo.save(productName);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        productTypeRepo.deleteById(id);
    }
}
