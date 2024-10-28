package dev.v3ktor.minimaltask.configuration;

import dev.v3ktor.minimaltask.security.MinimalTaskUserDetaisService;
import dev.v3ktor.minimaltask.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        http.cors( Customizer.withDefaults() );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public MinimalTaskUserDetaisService userDetailsService( UserService userService ) {
        return new MinimalTaskUserDetaisService( userService );
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5000");
            }

        };
    }

}
