package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.model.CustomerDetails;

public interface CustomerRepository extends MongoRepository<CustomerDetails, Integer> {

}
