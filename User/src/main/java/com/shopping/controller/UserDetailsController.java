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
import com.shopping.model.OrderModel;
import com.shopping.model.UserDetails;
import com.shopping.repository.UserRepository;
import com.shopping.service.UserService;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
	
	  @Autowired
	  private RestTemplate restTemplate;
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	//for creating/adding User
	@PostMapping("adduser")
	public UserDetails saveUserDetails(@RequestBody UserDetails userDetails ) {
		return userService.addUser(userDetails);
	}
	
	//Reading all User
	@GetMapping("/alluserDetails")
	public List<UserDetails> findAllUserDetails(){
		return userService.getUserDetails();
	}
	
	//Reading User by Id
	@GetMapping("/alluserDetails/{id}")
	public Optional<UserDetails> getUserById(@PathVariable int id) throws ApiRequestException{
		return Optional.of(userRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("USER NOT FOUND WITH THIS ID ::")));
	}
	
	//Updating User Data by Id
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateUserDetails(@PathVariable int id, @RequestBody UserDetails userDetails )
		{
			boolean isUserDetailsExist=userRepository.existsById(id);
			if(isUserDetailsExist) {
				userRepository.save(userDetails);
				return new ResponseEntity<Object>("user updated successfully with id " +id, HttpStatus.OK);
			}
			else 
			{
				throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
			}
			
		}
		
		// Deleting User Data by Id 
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteUserDetails (@PathVariable int id)
		{
			boolean isUserDetailsExist=userRepository.existsById(id);
			if(isUserDetailsExist) {
				userService.deleteById(id);
				return new ResponseEntity<Object>("user deleted with id"+id,HttpStatus.OK);
			}
			else
			{
				throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
			}

		}

		
		// For Adding Order



		
		  @PostMapping("/addorder") public String addOrder (@RequestBody OrderModel
		  order) { return
		  restTemplate.postForObject("http://localhost:8082/order/addorder", order ,
		  String.class);
		  
		  }
		  
		  
		  
		  
		  
		  // for Deleting Order
		  
		  
		  
		  @DeleteMapping("/cancelorder/{id}") public String
		  deleteorder(@PathVariable("id") int id) {
		  restTemplate.delete("http://localhost:8082/order/delete/" +id, String.class);
		  return "Your Order is successfully Canceled " + id; }
		  
		  
		  }
		  
		  
		 