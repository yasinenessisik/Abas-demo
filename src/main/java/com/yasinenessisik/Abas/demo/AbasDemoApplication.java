package com.yasinenessisik.Abas.demo;

import com.yasinenessisik.Abas.demo.model.Product;
import com.yasinenessisik.Abas.demo.model.ProductTransaction;
import com.yasinenessisik.Abas.demo.model.Transaction;
import com.yasinenessisik.Abas.demo.repository.ProductRepo;
import com.yasinenessisik.Abas.demo.repository.ProductTransactionRepo;
import com.yasinenessisik.Abas.demo.repository.TransactionRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class AbasDemoApplication implements ApplicationRunner {
	private final ProductRepo productRepo;
	private final TransactionRepo transactionRepo;
	private final ProductTransactionRepo productTransactionRepo;

    public AbasDemoApplication(ProductRepo productRepo, TransactionRepo transactionRepo, ProductTransactionRepo productTransactionRepo) {
        this.productRepo = productRepo;
        this.transactionRepo = transactionRepo;
        this.productTransactionRepo = productTransactionRepo;
    }

    public static void main(String[] args) {
		SpringApplication.run(AbasDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		loadInitialData();

		productTransactionRepo.findAll().stream()
				.forEach(productTransaction -> System.out.println(productTransaction.toString()));
	}
	public void loadInitialData(){

		Product product1 = new Product(2000);
		Product product2 = new Product(2001);
		Product product3 = new Product(2002);
		Product product4 = new Product(2003);
		Product product5 = new Product(2004);
		Product product6 = new Product(2005);
		Product product7 = new Product(2006);

		productRepo.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6,product7));

		Transaction transaction1 = new Transaction(1000);
		Transaction transaction2 = new Transaction(1001);
		Transaction transaction3 = new Transaction(1002);

		transactionRepo.saveAll(Arrays.asList(transaction1, transaction2, transaction3));

		BigDecimal price1t1 = new BigDecimal("100.51");
		BigDecimal price2t1 = new BigDecimal("200");
		BigDecimal price3t1 = new BigDecimal("150.86");
		BigDecimal price4t1 = new BigDecimal("250");
		BigDecimal price5t1 = new BigDecimal("244");

		ProductTransaction pt1t1 = new ProductTransaction(product1, transaction1, 12, price1t1);
		ProductTransaction pt2t1 = new ProductTransaction(product2, transaction1, 31, price2t1);
		ProductTransaction pt3t1 = new ProductTransaction(product3, transaction1, 22, price3t1);
		ProductTransaction pt4t1 = new ProductTransaction(product4, transaction1, 41, price4t1);
		ProductTransaction pt5t1 = new ProductTransaction(product5, transaction1, 55, price5t1);

		productTransactionRepo.saveAll(Arrays.asList(pt1t1,pt2t1,pt3t1,pt4t1,pt5t1));

		BigDecimal price1t2 = new BigDecimal("44.531").setScale(3);
		BigDecimal price2t2 = new BigDecimal("88.11");
		BigDecimal price3t2 = new BigDecimal("211");
		BigDecimal price4t2 = new BigDecimal("88.11");

		ProductTransaction pt1t2 = new ProductTransaction(product2, transaction2, 88, price1t2);
		ProductTransaction pt2t2 = new ProductTransaction(product3, transaction2, 121, price2t2);
		ProductTransaction pt3t2 = new ProductTransaction(product5, transaction2, 74, price3t2);
		ProductTransaction pt4t2 = new ProductTransaction(product3, transaction2, 14, price4t2);

		productTransactionRepo.saveAll(Arrays.asList(pt1t2,pt2t2,pt3t2,pt4t2));


		BigDecimal price1t3 = new BigDecimal("12.1");
		BigDecimal price2t3 = new BigDecimal("22.3");
		BigDecimal price3t3 = new BigDecimal("12.1");
		BigDecimal price4t3 = new BigDecimal("94");
		BigDecimal price5t3 = new BigDecimal("44.1");
		BigDecimal price6t3 = new BigDecimal("90");


		ProductTransaction pt1t3 = new ProductTransaction(product4, transaction3, 2, price1t3);
		ProductTransaction pt2t3 = new ProductTransaction(product5, transaction3, 3, price2t3);
		ProductTransaction pt3t3 = new ProductTransaction(product4, transaction3, 8, price3t3);
		ProductTransaction pt4t3 = new ProductTransaction(product3, transaction3, 16, price4t3);
		ProductTransaction pt5t3 = new ProductTransaction(product6, transaction3, 9, price5t3);
		ProductTransaction pt6t3 = new ProductTransaction(product7, transaction3, 19, price6t3);

		productTransactionRepo.saveAll(Arrays.asList(pt1t3,pt2t3,pt3t3,pt4t3,pt5t3,pt6t3));
	}
}
