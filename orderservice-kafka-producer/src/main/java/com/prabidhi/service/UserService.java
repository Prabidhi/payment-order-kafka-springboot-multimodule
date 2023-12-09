package com.prabidhi.service;


import com.prabidhi.entity.User;
import com.prabidhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    public List<User> getUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
