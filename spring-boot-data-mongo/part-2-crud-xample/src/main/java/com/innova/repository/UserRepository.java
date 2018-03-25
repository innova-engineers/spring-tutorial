package com.innova.repository;

import com.innova.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {

    Users findByUsernameEquals(String username);
}
