package com.yasinenessisik.Abas.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductTransaction {
    @Id
    @GeneratedValue
    private int productTransactionId;

    private int quantity;
    @Column(precision = 15, scale = 3)
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public ProductTransaction() {
    }

    public ProductTransaction(Product product,  Transaction transaction, int quantity, BigDecimal unitPrice ) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.transaction = transaction;
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public int getProductTransactionId() {
        return productTransactionId;
    }

    public void setProductTransactionId(int productTransactionId) {
        this.productTransactionId = productTransactionId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return "ProductTransaction{" +
                "productTransactionId=" + productTransactionId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", transactionId=" + (transaction != null ? transaction.getTransactionId() : "null") +
                ", transaction Number=" + (transaction != null ? transaction.getTransactionId() : "null") +
                ", product=" + (product != null ? product.getProductNumber() : "null") +
                '}';
    }
}
