package com.yasinenessisik.Abas.demo.controller;

import com.yasinenessisik.Abas.demo.repository.ProductTransactionRepo;
import com.yasinenessisik.Abas.demo.service.ProductTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("api/v1/transaction")
public class ProductTransactionController {
    private final ProductTransactionService productTransactionService;

    public ProductTransactionController(ProductTransactionService productTransactionService) {
        this.productTransactionService = productTransactionService;
    }

    @GetMapping("getTotalValue")
    public ResponseEntity<BigDecimal> getTotalValue(){
        return ResponseEntity.ok(productTransactionService.getTotalValue());
    }
    @GetMapping("getAveragePriceForAll")
    public ResponseEntity<BigDecimal> getAveragePriceForAll(){
        return ResponseEntity.ok(productTransactionService.getAveragePriceForAllProducts());
    }
    @GetMapping("getProductQuantitiesByOrder")
    public ResponseEntity<Map> getProductQuantitiesByOrder(){
        return ResponseEntity.ok(productTransactionService.getProductQuantitiesByOrder());
    }
    @GetMapping("getAveragePricePerProduct")
    public ResponseEntity<Map> getAveragePricePerProduct(){
        return ResponseEntity.ok(productTransactionService.getAveragePricePerProduct());
    }
}
