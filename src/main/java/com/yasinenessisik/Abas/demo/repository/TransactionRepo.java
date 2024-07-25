package com.yasinenessisik.Abas.demo.repository;

import com.yasinenessisik.Abas.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}
