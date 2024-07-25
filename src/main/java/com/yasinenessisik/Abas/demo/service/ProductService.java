package com.yasinenessisik.Abas.demo.service;

import com.yasinenessisik.Abas.demo.model.Product;
import com.yasinenessisik.Abas.demo.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    protected List<Product> findAll(){
        return productRepo.findAll();
    }
}
