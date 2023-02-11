package com.programming.techie.productservice.repository;

// import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.programming.techie.productservice.model.Product;

// import org.springframework.data.mongodb.repository.cdi.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
    @Query("{'skuCode': ?0}")
    Optional<Product> findBySkuCode(String skuCode);

    void deleteBySkuCode(String skuCode);
}
