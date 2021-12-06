package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.models.Product;
import com.shopping.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//for creating/adding Product
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}

	public List<Product> getProduct() {
		
		List<Product> product = productRepository.findAll();
		System.out.println("Getting Users from DB" + product);
		return product;
	}

	

		//For deleting By Id
		public void deleteById(int id) {
			productRepository.deleteById(id);
			
		}
}
