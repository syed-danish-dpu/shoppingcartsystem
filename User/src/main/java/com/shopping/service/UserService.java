package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.UserDetails;
import com.shopping.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//for creating/adding User
	public UserDetails addUser(UserDetails userDetails) {
		
		return userRepository.save(userDetails);
	}

	public List<UserDetails> getUserDetails() {
		
		List<UserDetails> userDetails =  userRepository.findAll();
		System.out.println("Getting Users from DB" + userDetails);
		return userDetails;
	}

	

		//For deleting By Id
		public void deleteById(int id) {
			userRepository.deleteById(id);
			
		}
	
	
	

}
