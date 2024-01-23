package com.MEC.User;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
    Optional<User> findByLogin(String login);
}
