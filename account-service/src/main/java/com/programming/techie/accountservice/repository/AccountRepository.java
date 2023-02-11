package com.programming.techie.accountservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.programming.techie.accountservice.model.Account;

public interface AccountRepository extends MongoRepository<Account, String>{
    @Query("{'name': ?0}")
    Optional<Account> findByName(String name);
}
