package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final List<User> users = new ArrayList<>();

    public UsersController() {
        users.add(new User(1, "admin"));
        users.add(new User(2, "Jim"));
        users.add(new User(3, "Tommy"));
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping()
    public List<User> getUsers(){
        return users;
    }

}
