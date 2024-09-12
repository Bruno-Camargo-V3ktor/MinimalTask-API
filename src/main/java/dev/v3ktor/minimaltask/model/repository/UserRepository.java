package dev.v3ktor.minimaltask.model.repository;

import dev.v3ktor.minimaltask.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> { }