package com.ratepay.challenge.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ratepay.challenge.bo.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class JsonReaderService {

    private final ResourceLoader resourceLoader;

    public JsonReaderService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<Buyer> readJsonFile() {
        final Logger logger = LoggerFactory.getLogger(JsonReaderService.class);
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter())
                    .create();

            Resource resource = resourceLoader.getResource("classpath:sample.json");

            try (InputStream inputStream = resource.getInputStream();
                 InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

                Type listType = new TypeToken<List<Buyer>>() {}.getType();
                List<Buyer> buyers =  gson.fromJson(reader, listType);

                buyers.stream()
                        .flatMap(buyer -> buyer.getOrders().stream())
                        .peek(order -> order.getProducts().forEach(product -> product.setOrder(order)))
                        .forEach(order -> order.setBuyer(buyers.stream().filter(b -> b.getOrders().contains(order)).findFirst().orElse(null)));

                return buyers;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}