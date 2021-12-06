package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.CustomerDetails;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDetails, Integer> {

	CustomerDetails findByCustEmail(String CustEmail);

}
