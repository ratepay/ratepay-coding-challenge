package com.ratepay.challenge.repository;

import com.ratepay.challenge.bo.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> { }