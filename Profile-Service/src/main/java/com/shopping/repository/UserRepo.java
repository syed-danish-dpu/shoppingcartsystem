package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.UserDetails;

@Repository
public interface UserRepo extends MongoRepository<UserDetails, Integer> {

}
