package dev.v3ktor.minimaltask.security;

import dev.v3ktor.minimaltask.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MinimalTaskUserDetaisService implements UserDetailsService {

    // Attributes
    private final UserService userService;


    // Constructor
    public MinimalTaskUserDetaisService(UserService userService) {
        this.userService = userService;
    }

    // Methods
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userDb = userService.getUserByUsername(username);

        return User
                .withUsername( userDb.getUsername() )
                .password( userDb.getPassword() )
                .build();
    }

}
