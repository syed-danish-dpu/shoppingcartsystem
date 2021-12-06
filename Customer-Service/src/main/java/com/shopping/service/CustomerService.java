package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.shopping.model.CustomerDetails;
import com.shopping.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomerService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository CustomerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	CustomerDetails foundedCustomer = CustomerRepository.findByCustEmail(username);
	if (foundedCustomer ==null) return null;
	String cEmail = foundedCustomer.getCustEmail();
	String cPassword = foundedCustomer.getCustPassword();
	return new User(cEmail, cPassword, new ArrayList<>());
	}


	
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
