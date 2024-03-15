package com.ratepay.challenge.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratepay.challenge.entity.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JsonReaderService {
    static final Logger logger = LoggerFactory.getLogger(JsonReaderService.class);

    private final ObjectMapper objectMapper;

    public JsonReaderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Buyer> readJsonFile() {
        try {
            List<Buyer> buyers = objectMapper
                    .readValue(new ClassPathResource("sample.json").getFile(), new TypeReference<List<Buyer>>() { });

            buyers.stream()
                    .flatMap(buyer -> buyer.getOrders().stream())
                    .peek(order -> order.getProducts().forEach(product -> product.setOrder(order)))
                    .forEach(order -> order.setBuyer(buyers.stream().filter(b -> b.getOrders().contains(order)).findFirst().orElse(null)));

            return buyers;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
