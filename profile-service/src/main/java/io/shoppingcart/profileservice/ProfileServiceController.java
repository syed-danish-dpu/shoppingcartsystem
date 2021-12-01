package io.shoppingcart.profileservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileServiceController {
	
		@RequestMapping("/profile")
		public String welcomeProfile() {
			return "Hello Profile";

	}

}
