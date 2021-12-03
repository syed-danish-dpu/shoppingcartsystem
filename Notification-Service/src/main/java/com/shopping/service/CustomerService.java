package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.CustomerDetails;
import com.shopping.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository CustomerRepository;
	
	//for creating/adding Customer
	public CustomerDetails addCustomer(CustomerDetails CustomerDetails) {
		
		return CustomerRepository.save(CustomerDetails);
	}

	public List<CustomerDetails> getCustomerDetails() {
		
		List<CustomerDetails> CustomerDetails =  CustomerRepository.findAll();
		System.out.println("Getting Customers from DB" + CustomerDetails);
		return CustomerDetails;
	}

	

		//For deleting By Id
		public void deleteById(int id) {
			CustomerRepository.deleteById(id);
			
		}
	
	
	

}
