package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.exception.ApiRequestException;
import com.shopping.model.CustomerAuthResponse;
import com.shopping.model.CustomerDetails;
import com.shopping.model.OrderModel;
import com.shopping.repository.CustomerRepository;
import com.shopping.service.CustomerService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



@RestController
@RequestMapping("/CustomerDetails")
public class CustomerDetailsController {

	@Autowired
	private  AuthenticationManager  authenticationManager;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerService CustomerService;

	@Autowired
	private CustomerRepository CustomerRepository;

	// for creating/adding Customer
	@PostMapping("/addCustomer")
	public CustomerDetails saveCustomerDetails(@RequestBody CustomerDetails CustomerDetails) {
		return CustomerService.addCustomer(CustomerDetails);
	}

	// Reading all Customer
	@GetMapping("/allCustomerDetails")
	public List<CustomerDetails> findAllCustomerDetails() {
		return CustomerService.getCustomerDetails();
	}

	// Reading Customer by Id
	@GetMapping("/allCustomerDetails/{id}")
	public Optional<CustomerDetails> getCustomerById(@PathVariable int id) throws ApiRequestException {
		return Optional.of(CustomerRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("Customer NOT FOUND WITH THIS ID ::")));
	}

	// Updating Customer Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCustomerDetails(@PathVariable int id,
			@RequestBody CustomerDetails CustomerDetails) {
		boolean isCustomerDetailsExist = CustomerRepository.existsById(id);
		if (isCustomerDetailsExist) {
			CustomerRepository.save(CustomerDetails);
			return new ResponseEntity<Object>("Customer updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS Customer NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting Customer Data by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomerDetails(@PathVariable int id) {
		boolean isCustomerDetailsExist = CustomerRepository.existsById(id);
		if (isCustomerDetailsExist) {
			CustomerService.deleteById(id);
			return new ResponseEntity<Object>("Customer deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS Customer NOT FOUND WITH THIS ID ::");
		}

	}

	// For Adding Order
	@PostMapping("/addorder")

	public String addOrder(@RequestBody OrderModel order) {
		return restTemplate.postForObject("http://localhost:8082/order/addorder", order, String.class);
	}

	// for Deleting Order

	@DeleteMapping("/cancelorder/{id}")
	public String deleteorder(@PathVariable("id") int id) {
		restTemplate.delete("http://localhost:8082/order/delete/" + id, String.class);
		return "Your Order is successfully Canceled " + id;
	}

	@PostMapping("/auth")
	private ResponseEntity<?> authCustomer(@RequestBody CustomerDetails customer) {
		String email = customer.getCustEmail();
		String password = customer.getCustPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

		} catch (Exception e) {

			return ResponseEntity.ok(new CustomerAuthResponse("Error during customer Authentication" + email));
		}
		return ResponseEntity.ok(new CustomerAuthResponse("Successfully Authenticated customer " + email));

	}
}
