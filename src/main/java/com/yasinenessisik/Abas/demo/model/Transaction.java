package com.yasinenessisik.Abas.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private int transactionNumber;
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<ProductTransaction> productTransactions = new HashSet<>();

    public Transaction() {
    }

    public Transaction(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Set<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }

    public void setProductTransactions(Set<ProductTransaction> productTransactions) {
        this.productTransactions = productTransactions;
    }
}
