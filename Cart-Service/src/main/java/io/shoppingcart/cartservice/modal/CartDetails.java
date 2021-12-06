package io.shoppingcart.cartservice.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	@Document(collection = "cart")
	public class CartDetails {
		@Id
		private int cartId;
		private double totalPrice;
		
		public CartDetails() {
	
		}

			public CartDetails(int cartId, double totalPrice) {
			super();
			this.cartId = cartId;
			this.totalPrice = totalPrice;
		}



		@Override
			public String toString() {
				return "CartDetails [cartId=" + cartId + ", totalPrice=" + totalPrice + "]";
			}

		
		public int getCartId() {
			return cartId;
		}



		public void setCartId(int cartId) {
			this.cartId = cartId;
		}



		public double getTotalPrice() {
			return totalPrice;
		}



		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
	
		
		
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	