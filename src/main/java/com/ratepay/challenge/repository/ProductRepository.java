package com.ratepay.challenge.repository;

import com.ratepay.challenge.bo.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
