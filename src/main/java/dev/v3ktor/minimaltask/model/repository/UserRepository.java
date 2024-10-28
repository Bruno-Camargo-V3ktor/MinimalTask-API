package dev.v3ktor.minimaltask.model.repository;

import dev.v3ktor.minimaltask.model.entity.Task;
import dev.v3ktor.minimaltask.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
}