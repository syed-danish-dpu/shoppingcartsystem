package com.shopping.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.OrderModel;


@Repository
public interface OrderRepo extends MongoRepository<OrderModel, Integer>{

}



	

	


