package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

}

