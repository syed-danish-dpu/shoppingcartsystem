package io.shoppingcart.cartservice.repository;

	import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
	import org.springframework.data.mongodb.repository.MongoRepository;

import io.shoppingcart.cartservice.modal.CartDetails;


	public interface CartRepository extends MongoRepository<CartDetails, Integer> {


}
