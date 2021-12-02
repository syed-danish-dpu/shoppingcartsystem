package io.shoppingcart.cartservice.service;	

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import io.shoppingcart.cartservice.modal.CartDetails;
	import io.shoppingcart.cartservice.repository.CartRepository;

	@Service
	public class CartService {
		
		@Autowired
		private CartRepository cartRepository;
		
		//for creating/adding User
		public CartDetails addCart(CartDetails cartDetails) {
			
			return cartRepository.save(cartDetails);
		}

		public List<CartDetails> getCartDetails() {
			
			List<CartDetails> cartDetails =  cartRepository.findAll();
			System.out.println("Getting Cart from DB" + cartDetails);
			return cartDetails;
		}

		

			//For deleting By Id
			public void deleteById(int id) {
				cartRepository.deleteById(id);
				
			}


}
