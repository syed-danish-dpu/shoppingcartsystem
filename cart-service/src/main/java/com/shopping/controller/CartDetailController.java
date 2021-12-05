package com.shopping.controller;

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
import org.springframework.web.client.RestTemplate;

import com.shopping.exception.ApiRequestException;
import com.shopping.modal.CartDetails;
import com.shopping.modal.Product;

import com.shopping.repository.CartRepository;
import com.shopping.service.CartService;

@RestController
@RequestMapping("/cartDetails")
public class CartDetailController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartRepository cartRepository;

	// for creating/adding Cart
	@PostMapping("/addcart")
	public CartDetails saveCartDetails(@RequestBody CartDetails cartDetails) {
		return cartService.addCart(cartDetails);
	}

	// Reading all Cart
	@GetMapping("/allcartDetails")
	public List<CartDetails> findAllCartDetails() {
		return cartService.getCartDetails();
	}

	// Reading Cart by Id
	@GetMapping("/allcartDetails/{id}")
	public Optional<CartDetails> getCartById(@PathVariable int id) throws ApiRequestException {
		return Optional.of(cartRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("Cart NOT FOUND WITH THIS ID ::")));
	}

	// Updating Cart Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCartDetails(@PathVariable int id, @RequestBody CartDetails cartDetails) {
		boolean isCartDetailsExist = cartRepository.existsById(id);
		if (isCartDetailsExist) {
			cartRepository.save(cartDetails);
			return new ResponseEntity<Object>("cart updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting Cart Data by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCartDetails(@PathVariable int id) {
		boolean isCartDetailsExist = cartRepository.existsById(id);
		if (isCartDetailsExist) {
			cartService.deleteById(id);
			return new ResponseEntity<Object>("cart deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS Cart NOT FOUND WITH THIS ID ::");
		}

	}
	// For Adding Product



	
	  @PostMapping("/addproduct") public String addProduct (@RequestBody Product
	  product) { return
	  restTemplate.postForObject("http://localhost:8081/product/addproduct", product ,
	  String.class);
	  
	  }
	  
	  
	  
	  
	  
	  // for Deleting Product
	  
	  
	  
	  @DeleteMapping("/cancelproduct/{id}") public String
	  deleteproduct(@PathVariable("id") int id) {
	  restTemplate.delete("http://localhost:8081/product/delete/" +id, String.class);
	  return "Your Order is successfully Canceled " + id; }
	  
	  
	  }
	  


