package com.example.springboodrest;

import com.example.springboodrest.service.AuthorizationService;
import com.example.springboodrest.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
    @ConditionalOnProperty("example.profile.dev")
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @ConditionalOnProperty("example.profile.dev")
    public UserRepository userRepository() {
        return new UserRepository();
    }
}