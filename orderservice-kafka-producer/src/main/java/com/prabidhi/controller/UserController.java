package com.prabidhi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.prabidhi.entity.User;
import com.prabidhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getOrder(){
        return userService.getUsers();
    }

    @PostMapping("/create")
    public User saveOrder(@RequestBody User user) throws JsonProcessingException {
        return userService.createUser(user);

    }

}
