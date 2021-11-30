package io.shoppingcart.Customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	public String welcomeCustomer() {
		return "You are Login";
	}

}
