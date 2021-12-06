package controller;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import repository.AdminRepository;

import model.Admin;
import model.Order;

	@RestController
	@RequestMapping("/admin")
	public class AdminController {
		
		@Autowired
		private AdminRepository adminRepository;
		
		@Autowired
		private RestTemplate  restTemplate;
		
		//Adding Admin
		@PostMapping("/addadmin")
		public String saveAdmin(@RequestBody Admin admin) {
			 adminRepository.save(admin) ;
			 return "Admin Saved Successfully with id:" +admin.getaId();
			
		}
		
		//Reading All admin 
		@GetMapping("/alladmins")
		public List<Admin> getallAdmins(){
			return adminRepository.findAll();
			
		}
		
		//Reading Admin by ID
		
		
		@GetMapping("/alladmins/{id}")
		public Optional<Admin> getadminbyId(@PathVariable int id){
			return adminRepository.findById(id);
			
		}
		
		//Reading orders  By id
		@GetMapping("/getallorders/{id}") 
		public Order getOrderById (@PathVariable("id") int id) 
		{
		  return restTemplate.getForObject("http://localhost:8082/order/orders/" +id , Order.class);
		  
		  }
		
		
		//Reading All orders 
		@GetMapping("/getallorders") 
		public String getallOrder() 
		{
		   return restTemplate.getForObject("http://localhost:8082/order/allorders", String.class);
		  
		  }

}
