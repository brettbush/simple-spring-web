package com.brettbush.simplespringweb.controller;

import com.brettbush.simplespringweb.entity.User;
import com.brettbush.simplespringweb.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
