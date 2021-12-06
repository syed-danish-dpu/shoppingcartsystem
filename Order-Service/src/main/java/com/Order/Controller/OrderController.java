package com.Order.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Order.Models.OrderModel;
import com.Order.Repo.OrderRepo;
import com.Order.Services.OrderService;

@RestController
@RequestMapping("/order")

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepo orderRepo;
	
	// Creating or Adding Order
	@PostMapping("/addorder")
	public String saveOrder(@RequestBody OrderModel order) {
		orderService.addOrder(order);
		return "Order is Placed with its Details and will be Proceesed Soon" ;
	}

	//Reading all Orders
	@GetMapping("/allorders")
	public List <OrderModel> getOrderModel(){
		return orderRepo.findAll();	
	}
	
	//Deleting order
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<Object> deleteOrder (@PathVariable int id) throws Exception{
		boolean isOrderExist = orderRepo.existsById(id);
		if(isOrderExist) {
			orderService.deleteById(id);
			return new ResponseEntity <Object> ("Order deleted with id " + id, HttpStatus.OK);
		} else {
			throw new Exception("CANNOT DELETE ORDER, AS ORDER NOT FOUND WITH THIS ID");
		}
		
		
	}

}
