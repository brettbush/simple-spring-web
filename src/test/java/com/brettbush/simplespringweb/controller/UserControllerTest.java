package com.brettbush.simplespringweb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveUserTest() throws Exception {
        mockMvc.perform(get("/users/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"John Smith\",\"username\":\"john.smith\",\"userType\":\"ACCOUNT_MANAGER\"}]"));
    }
}
