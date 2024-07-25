package com.yasinenessisik.Abas.demo.repository;

import com.yasinenessisik.Abas.demo.model.Product;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByProductNumber(int number);
}
