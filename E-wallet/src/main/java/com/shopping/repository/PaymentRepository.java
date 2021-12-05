package com.shopping.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.shopping.models.PaymentDetails;

public interface PaymentRepository extends MongoRepository <PaymentDetails , Integer> {

}
