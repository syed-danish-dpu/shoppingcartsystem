package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.models.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
