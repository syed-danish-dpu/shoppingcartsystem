package io.shoppingcart.productservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

		@GetMapping("/product")
		public String WelcomeProduct() {
				return "Hello Product";
		}
}
