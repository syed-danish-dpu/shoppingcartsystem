package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.model.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails, Integer> {

}
