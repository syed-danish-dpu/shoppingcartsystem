package com.Order.Repo;


import com.Order.Models.OrderModel;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends MongoRepository<OrderModel, Integer>{

}



	

	


