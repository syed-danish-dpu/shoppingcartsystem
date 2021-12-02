package CaseStudy.PaymentsService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import CaseStudy.PaymentsService.model.PaymentDetails;

public interface PaymentRepository extends MongoRepository <PaymentDetails , Integer> {

}
