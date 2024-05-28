package com.example.demo.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List; // Import the List class

public interface UserHttpClient {


    @GetExchange("/users") // Define the endpoint
    List<User> findAll();

    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);
}
