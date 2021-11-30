package io.shoppingcart.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@GetMapping
	public String welcomeAdmin() {
		return "Admin login";
	}
}
