package com.yasinenessisik.Abas.demo.repository;

import com.yasinenessisik.Abas.demo.model.Product;
import com.yasinenessisik.Abas.demo.model.ProductTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
ProductTransactionRepo extends JpaRepository<ProductTransaction,Integer> {

    List<ProductTransaction> findByProduct(Product product);
}
