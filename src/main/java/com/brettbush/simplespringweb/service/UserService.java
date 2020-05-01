package com.brettbush.simplespringweb.service;

import com.brettbush.simplespringweb.entity.User;
import com.brettbush.simplespringweb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
