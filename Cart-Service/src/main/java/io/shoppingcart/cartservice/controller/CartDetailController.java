package io.shoppingcart.cartservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shoppingcart.cartservice.exception.ApiRequestException;
import io.shoppingcart.cartservice.modal.CartDetails;
import io.shoppingcart.cartservice.repository.CartRepository;
import io.shoppingcart.cartservice.service.CartService;

@RestController
@RequestMapping("/cartDetails")
public class CartDetailController {
		
		@Autowired
		private CartService cartService;
		
		@Autowired
		private CartRepository cartRepository;
		
		//for creating/adding Cart
		@PostMapping("/addcart")
		public CartDetails saveCartDetails(@RequestBody CartDetails cartDetails ) {
			return cartService.addCart(cartDetails);
		}
		
		//Reading all User
		@GetMapping("/allcartDetails")
		public List<CartDetails> findAllCartDetails(){
			return cartService.getCartDetails();
		}
		
		//Reading User by Id
		@GetMapping("/allcartDetails/{id}")
		public Optional<CartDetails> getCartById(@PathVariable int id) throws ApiRequestException{
			return Optional.of(cartRepository.findById(id)
					.orElseThrow(() -> new ApiRequestException("USER NOT FOUND WITH THIS ID ::")));
		}
		
		//Updating User Data by Id
			@PutMapping("/update/{id}")
			public ResponseEntity<Object> updateCartDetails(@PathVariable int id, @RequestBody CartDetails cartDetails )
			{
				boolean isCartDetailsExist=cartRepository.existsById(id);
				if(isCartDetailsExist) {
					cartRepository.save(cartDetails);
					return new ResponseEntity<Object>("cart updated successfully with id " +id, HttpStatus.OK);
				}
				else 
				{
					throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
				}
				
			}
			
			// Deleting User Data by Id 
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<Object> deleteCartDetails (@PathVariable int id)
			{
				boolean isCartDetailsExist=cartRepository.existsById(id);
				if(isCartDetailsExist) {
					cartService.deleteById(id);
					return new ResponseEntity<Object>("user deleted with id"+id,HttpStatus.OK);
				}
				else
				{
					throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
				}

			}
			

		}


