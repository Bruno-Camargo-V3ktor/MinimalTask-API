package dev.v3ktor.minimaltask.service;

import dev.v3ktor.minimaltask.exception.EntityNotFindException;
import dev.v3ktor.minimaltask.model.entity.User;
import dev.v3ktor.minimaltask.model.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //Atributos
    @Autowired private UserRepository userRepository;

    //Métodos
    public User getUserById(String id )
    {
        return userRepository.findById( new ObjectId( id ) ).orElseThrow( () -> new EntityNotFindException("User not exist") );
    }

    public User getUserByUsername(String username )
    {
        return userRepository.findByUsername( username ).orElse( null );
    }

    public User createUser( User newUser )
    {
        var user = getUserByUsername( newUser.getUsername() );
        if ( user != null ) { return null; }

        return userRepository.save( newUser );
    }



}
