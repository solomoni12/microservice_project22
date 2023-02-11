package com.programming.techie.orderservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.programming.techie.orderservice.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
    @Query("{'orderNumber': ?0}")
    Optional<Order> findByOrderNumber(String orderNumber);
}
