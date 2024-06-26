package com.example.demo.user;

import java.util.List; // Import the correct List class
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserRestClient {
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://jsonplaceholder.t ypicode.com")
        .build();
    }

    public List<User> findAll() {
        return restClient.get().uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

    }

    public User findById(Integer id) {
        return restClient.get().uri("/users/{id}", id)
                .retrieve()
                .body(User.class); //Model of the User class
    }
}
