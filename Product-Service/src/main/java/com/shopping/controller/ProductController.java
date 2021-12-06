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
import com.shopping.models.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	//for creating/adding Product
	@PostMapping("addproduct")
	public Product saveProduct(@RequestBody Product product ) {
		return productService.addProduct(product);
	}
	
	//Reading all Product
	@GetMapping("/allproduct")
	public List<Product> findAllProduct(){
		return productService.getProduct();
	}
	
	//Reading Product by Id
	@GetMapping("/allproduct/{id}")
	public Optional<Product> getProductById(@PathVariable int id) throws ApiRequestException{
		return Optional.of(productRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("PRODUCT NOT FOUND WITH THIS ID ::")));
	}
	
	//Updating User Data by Id
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product )
		{
			boolean isProductExist=productRepository.existsById(id);
			if(isProductExist) {
				productRepository.save(product);
				return new ResponseEntity<Object>("product updated successfully with id " +id, HttpStatus.OK);
			}
			else 
			{
				throw new ApiRequestException("CAN NOT UPDATE AS PRODUCT NOT FOUND WITH THIS ID ::");
			}
			
		}
		
		// Deleting User Data by Id 
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteProduct (@PathVariable int id)
		{
			boolean isProductExist=productRepository.existsById(id);
			if(isProductExist) {
				productService.deleteById(id);
				return new ResponseEntity<Object>("product deleted with id"+id,HttpStatus.OK);
			}
			else
			{
				throw new ApiRequestException("CAN NOT DELETE AS PRODUCT NOT FOUND WITH THIS ID ::");
			}

		}
		

	}
