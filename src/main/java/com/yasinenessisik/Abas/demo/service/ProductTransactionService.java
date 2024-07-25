package com.yasinenessisik.Abas.demo.service;

import com.yasinenessisik.Abas.demo.model.Product;
import com.yasinenessisik.Abas.demo.model.ProductTransaction;
import com.yasinenessisik.Abas.demo.repository.ProductRepo;
import com.yasinenessisik.Abas.demo.repository.ProductTransactionRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductTransactionService {

    private final ProductTransactionRepo productTransactionRepo;
    private final ProductService productService;

    public ProductTransactionService(ProductTransactionRepo productTransactionRepo, ProductService productService) {
        this.productTransactionRepo = productTransactionRepo;
        this.productService = productService;
    }

    public BigDecimal getTotalValue(){
        productTransactionRepo.findAll().forEach(pt ->
                System.out.println("Quantity: " + pt.getQuantity() + ", Unit Price: " + pt.getUnitPrice())
        );
        BigDecimal sum = productTransactionRepo.findAll().stream()
                .map(pt -> pt.getUnitPrice().multiply(new BigDecimal(pt.getQuantity())))
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        return sum.setScale(5, RoundingMode.HALF_UP); // İki ondalık basamağa yuvarlama

    }
    public BigDecimal getAveragePriceForAllProducts(){
        List<ProductTransaction> transactions = productTransactionRepo.findAll();
        int totalQuantity = transactions.stream().mapToInt(from -> from.getQuantity()).sum();
        if (totalQuantity == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal totalPrice = getTotalValue();
        System.out.println(totalPrice);
        return totalPrice.divide(new BigDecimal(totalQuantity), RoundingMode.HALF_DOWN);
    }

    public Map<Integer, BigDecimal> getAveragePricePerProduct() {
        List<Product> products = productService.findAll();

        return products.stream()
                .collect(Collectors.toMap(
                        Product::getProductNumber,
                        product -> {
                            List<ProductTransaction> transactions = getTransactionsByProductId(product);
                            BigDecimal totalPrice = calculateTotalPrice(transactions);
                            int totalQuantity = calculateTotalQuantity(transactions);
                            return calculateAveragePrice(totalPrice, totalQuantity);
                        }
                ));
    }
    public Map<Integer, Map<Integer, Integer>> getProductQuantitiesByOrder() {
        List<Product> products = productService.findAll();

        return products.stream()
                .collect(Collectors.toMap(
                        Product::getProductNumber,
                        product -> {
                            List<ProductTransaction> transactions = getTransactionsByProductId(product);

                            return transactions.stream()
                                    .collect(Collectors.toMap(
                                            pt -> pt.getTransaction().getTransactionNumber(),
                                            ProductTransaction::getQuantity,
                                            Integer::sum
                                    ));
                        }
                ));
    }

    public List<ProductTransaction> getTransactionsByProductId(Product product) {
        return productTransactionRepo.findByProduct(product);
    }
    public BigDecimal calculateTotalPrice(List<ProductTransaction> transactions) {
        return transactions.stream()
                .map(pt -> pt.getUnitPrice().multiply(new BigDecimal(pt.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int calculateTotalQuantity(List<ProductTransaction> transactions) {
        return transactions.stream()
                .mapToInt(ProductTransaction::getQuantity)
                .sum();
    }
    public BigDecimal calculateAveragePrice(BigDecimal totalPrice, int totalQuantity) {
        return totalQuantity > 0 ? totalPrice.divide(new BigDecimal(totalQuantity), BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO;
    }

}
