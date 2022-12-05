package com.ratepay.challenge.util;

import com.ratepay.challenge.bo.Buyer;
import com.ratepay.challenge.bo.Order;
import com.ratepay.challenge.bo.Product;
import com.ratepay.challenge.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * This class is used to populate database with some test data on startup.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final BuyerRepository buyerRepository;

    @Override
    public void run(String... args) {

        Order order1 = new Order(asList(new Product("Book", new BigDecimal("1.20")), new Product("Cup", new BigDecimal("3.50"))), new BigDecimal("4.70"));
        Order order2 = new Order(singletonList(new Product("Shelf", new BigDecimal("70.00"))), new BigDecimal("70.00"));
        Order order3 = new Order(singletonList(new Product("Guitar", new BigDecimal("250.00"))), new BigDecimal("250.00"));

        Order order4 = new Order(asList(new Product("Ball", new BigDecimal("29.00")), new Product("Shoes", new BigDecimal("120.00"))), new BigDecimal("149.00"));
        Order order5 = new Order(singletonList(new Product("Desk", new BigDecimal("499.00"))), new BigDecimal("499.00"));
        order4.setCreated(OffsetDateTime.now().minusDays(10));
        order5.setCreated(OffsetDateTime.now().minusDays(10));

        log.info("Buyer saved: {}", buyerRepository.save(new Buyer("Alice", asList(order1, order2, order3))));
        log.info("Buyer saved: {}", buyerRepository.save(new Buyer("John", asList(order4, order5))));
    }
}
