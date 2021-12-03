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

import com.shopping.exception.ApiRequestException;
import com.shopping.model.UserDetails;
import com.shopping.repository.UserRepo;
import com.shopping.service.UserService;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepository;
	
	//for creating/adding User
	@PostMapping("/adduser")
	public UserDetails saveUserDetails(@RequestBody UserDetails userDetails ) {
		return userService.addUser(userDetails);
	}
	
	//Reading all User
	@GetMapping("/alluserDetail")
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
		

	}


