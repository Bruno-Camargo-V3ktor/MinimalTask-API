package dev.v3ktor.minimaltask.controller;

import dev.v3ktor.minimaltask.model.entity.User;
import dev.v3ktor.minimaltask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/users")
public class UserResource {

    //Atributos
    @Autowired private UserService service;

    //Endpoints
    @PostMapping
    public ResponseEntity< User > create( @RequestBody User user )
    {
        var savedUser = service.createUser( user );
        if( savedUser == null ) { return ResponseEntity.status( HttpStatus.BAD_REQUEST ).build(); }

        return ResponseEntity.status( HttpStatus.CREATED ).body( savedUser );
    }

    @GetMapping("/{USER_ID}")
    public ResponseEntity< User > getById( @PathVariable("USER_ID") String id )
    {
        var user = service.getUserById(id);
        return ResponseEntity.ok( user );
    }

    @GetMapping("/exist/{USERNAME}")
    public ResponseEntity< Boolean > existedByUsername( @PathVariable("USERNAME") String username )
    {
        var user = service.getUserByUsername( username );
        return ResponseEntity.ok( user != null );
    }

}