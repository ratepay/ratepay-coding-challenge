package com.ratepay.challenge.repository;

import com.ratepay.challenge.bo.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> { }
