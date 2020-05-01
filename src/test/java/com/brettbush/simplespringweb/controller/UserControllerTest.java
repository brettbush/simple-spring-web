package com.brettbush.simplespringweb.controller;

import com.brettbush.simplespringweb.entity.User;
import com.brettbush.simplespringweb.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void retrieveUsersTest() throws Exception {
        User john = User.builder().id(1L).name("John Smith").username("john.smith").userType("ACCOUNT_MANAGER").build();
        User sally = User.builder().id(2L).name("Sally Wurthers").username("sally.wurthers").userType("CLIENT").build();
        when(userRepository.findAll()).thenReturn(Arrays.asList(john, sally));

        mockMvc.perform(get("/users/"))
                .andExpect(status().isOk())
                .andExpect(content().json("["
                        + objectMapper.writeValueAsString(john) + ","
                        + objectMapper.writeValueAsString(sally)
                        + "]"));
    }

    @Test
    public void retrieveUserByIdTest() throws Exception {
        User margo = User.builder().id(3L).build();
        when(userRepository.findById(3L)).thenReturn(Optional.of(margo));

        mockMvc.perform(get("/users/3"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(margo)));
    }

    @Test
    public void receiveUserNotFoundErrorTest() throws Exception {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/3"))
                .andExpect(status().isNotFound());

    }
}
