package com.vti.loshipBE.repositories;

import com.vti.loshipBE.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);
}
