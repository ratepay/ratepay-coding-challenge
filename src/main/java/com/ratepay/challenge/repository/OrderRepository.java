package com.ratepay.challenge.repository;


import com.ratepay.challenge.bo.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
