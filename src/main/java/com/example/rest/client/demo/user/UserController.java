package com.example.rest.client.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserHttpClient userHttpClient;

    public UserController(UserHttpClient userHttpClient) {
        this.userHttpClient = userHttpClient;
    }


    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userHttpClient.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userHttpClient.getUser(id);
    }
}
