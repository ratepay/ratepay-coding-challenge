package com.ratepay.challenge.repository;

import com.ratepay.challenge.bo.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
