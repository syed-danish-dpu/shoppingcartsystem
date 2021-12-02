package CaseStudy.PaymentsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
@RequestMapping("/hello")
public class HelloController3 {
		@GetMapping("/hello")
		public String helloworld() {
			return "Hello World!";
		}
	}