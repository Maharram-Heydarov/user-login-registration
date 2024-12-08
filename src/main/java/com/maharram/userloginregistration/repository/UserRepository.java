package com.maharram.userloginregistration.repository;

import java.util.Optional;

import com.maharram.userloginregistration.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
