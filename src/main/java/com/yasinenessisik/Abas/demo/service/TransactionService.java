package com.yasinenessisik.Abas.demo.service;

import com.yasinenessisik.Abas.demo.model.Product;
import com.yasinenessisik.Abas.demo.model.Transaction;
import com.yasinenessisik.Abas.demo.repository.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }


    protected Transaction saveTransaction(Transaction transaction){
        return transactionRepo.save(transaction);
    }
}
