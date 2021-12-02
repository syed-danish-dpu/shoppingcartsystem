package CaseStudy.PaymentsService.Service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CaseStudy.PaymentsService.model.PaymentDetails;
import CaseStudy.PaymentsService.repo.PaymentRepository;

@Service
public class PaymentService {
	 @Autowired
	    private PaymentRepository repository;

	    public PaymentDetails doPay(PaymentDetails payment){
	        payment.setPaymentStatus(paymentStatus());
	        payment.setTxId(UUID.randomUUID().toString());
	        return repository.save(payment);
	    }

	    private String paymentStatus(){
	    	
	        return new Random().nextBoolean()?"success":"failure";
	    }

}
