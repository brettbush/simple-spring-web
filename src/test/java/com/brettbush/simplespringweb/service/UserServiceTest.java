package com.brettbush.simplespringweb.service;

import com.brettbush.simplespringweb.entity.User;
import com.brettbush.simplespringweb.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setup(){
        userService = new UserService(userRepository);
    }

    @Test
    public void findAllUsersEmptyTest(){
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        List<User> userList = userService.findAllUsers();
        Assertions.assertNotNull(userList);
        Assertions.assertEquals(0, userList.size());
    }
}
