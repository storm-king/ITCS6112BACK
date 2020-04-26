/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;
import com.SSDIproject.ManpowerAllocatorSSDI.Services.UsersService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author matthewthayer
 */

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {
    
    @InjectMocks
    UsersController usersController;
    
    @Mock
    UsersService UsersService;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }

    /**
     * Test Success of authenticateUser method, of class UsersController.
     */
    @Test
    public void testAuthenticateUser_request_OK() 
    {
        Users user = new Users("mthayer2","Matt","Thayer","ExamplePass123");//whichever data your entity class have
        
        doReturn(true).when(UsersService).authenticateUser("mthayer2", "ExamplePass123");

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/users/authenticate")
                    .content(asJsonString(user))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            fail();
            Logger.getLogger(UsersControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of Fail because of incorrect password authenticateUser method, of class UsersController.
     */
    @Test
    public void testAuthenticateUser_request_UNAUTHORIZED_incorrect_password() 
    {
        Users user = new Users("mthayer2","Matt","Thayer","ExamplePass123");//whichever data your entity class have

        doReturn(false).when(UsersService).authenticateUser("mthayer2", "Badpass123");

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/users/authenticate")
                    .content(asJsonString(user))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isUnauthorized())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(UsersControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of Fail because of incorrect username authenticateUser method, of class UsersController.
     */
    @Test
    public void testAuthenticateUser_request_UNAUTHORIZED_incorrect_username() 
    {
        Users user = new Users("mthayer2","Matt","Thayer","ExamplePass123");//whichever data your entity class have

        doReturn(false).when(UsersService).authenticateUser("mthayer", "ExamplePass123");

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/users/authenticate")
                    .content(asJsonString(user))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isUnauthorized())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(UsersControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    //Helper Method to turn Objects into JSON String
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
