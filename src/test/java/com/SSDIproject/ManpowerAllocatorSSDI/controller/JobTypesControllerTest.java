/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobTypesService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author stormking
 */
@ExtendWith(MockitoExtension.class)
public class JobTypesControllerTest {

//    @InjectMocks
//    JobTypesController usersController;
//
//    @Mock
//    UsersService UsersService;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
//    }
//
//    /**
//     * Test of authenticateUser method, of class UsersController.
//     */
//    @Test
//    public void testAuthenticateUser_request_OK() {
//        Users user = new Users("mthayer2", "Matt", "Thayer", "ExamplePass123");//whichever data your entity class have
//
//        when(UsersService.authenticateUser("mthayer2", "ExamplePass123")).thenReturn(true);
//
//        try {
//            mockMvc.perform(MockMvcRequestBuilders.post("/users/authenticate")
//                    .content(asJsonString(user))
//                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType("application/json"));
//        } catch (Exception ex) {
//            fail();
//            Logger.getLogger(UsersControllerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
////Helper Method to turn Objects into JSON String
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
