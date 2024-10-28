package dev.v3ktor.minimaltask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( request -> {

            request.requestMatchers( "/api/users/{USER_ID}" ).authenticated();
            request.requestMatchers( "/api/{USER_ID}/tasks", "/api/{USER_ID}/tasks/**" ).authenticated();

            request.anyRequest().permitAll();
        } );

        http.httpBasic( Customizer.withDefaults() );
        http.formLogin( AbstractHttpConfigurer::disable );
        http.csrf(  AbstractHttpConfigurer::disable  );

        return http.build();
    }

}
