package com.ratepay.challenge.util;

import com.ratepay.challenge.repository.BuyerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to populate database with some test data on startup.
 */
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    private final BuyerRepository buyerRepository;
    private final JsonReaderService jsonReaderService;

    public DatabaseInitializer(BuyerRepository buyerRepository, JsonReaderService jsonReaderService) {
        this.buyerRepository = buyerRepository;
        this.jsonReaderService = jsonReaderService;
    }

    @Override
    public void run(String... args) {
        jsonReaderService.readJsonFile().forEach((buyer) -> log.info("Buyer saved: {}",
                buyerRepository.save(buyer)));
    }
}
