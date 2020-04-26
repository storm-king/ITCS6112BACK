/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Users;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.UsersRepository;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author matthewthayer
 */

@ExtendWith(MockitoExtension.class)
public class UsersServiceTest {
    
    @InjectMocks
    UsersService usersService;
    
    @Mock UsersRepository UsersRepository;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
    }
    
    /**
     * Test of authenticateUser method with correct username and password, of class UsersService.
     */
    @Test
    public void testAuthenticateUser_Username_Password_Correct() {
      Users exampleUsers = new Users("mthayer2","Matt","Thayer","ExamplePass123");
      
      Optional<Users> expResult = Optional.of(exampleUsers);
      doReturn(expResult).when(UsersRepository).findById("mthayer2");
      
      boolean result = usersService.authenticateUser("mthayer2","ExamplePass123");
      
      assertTrue(result);
    }
    
     /**
     * Test of authenticateUser method with correct username but incorrect password, of class UsersService.
     */
    @Test
    public void testAuthenticateUser_Username_Correct_Password_Incorrect() {
      Users exampleUsers = new Users("mthayer2","Matt","Thayer","ExamplePass123");
      
      Optional<Users> expResult = Optional.of(exampleUsers);
      doReturn(expResult).when(UsersRepository).findById("mthayer2");
      
      boolean result = usersService.authenticateUser("mthayer2","BadPass123");
      
      assertFalse(result);
    }
    
     /**
     * Test of authenticateUser method with incorrect username but correct password, of class UsersService.
     */
    @Test
    public void testAuthenticateUser_Username_Incorrect_Password_Correct() {
      Users exampleUsers = new Users("mthayer2","Matt","Thayer","ExamplePass123");
      
      Optional<Users> expResult = Optional.empty();
      doReturn(expResult).when(UsersRepository).findById("mthayer");
      
      boolean result = usersService.authenticateUser("mthayer","ExamplePass123");
      
      assertFalse(result);
    }

    /**
     * Test of getUser method, of class UsersService.
     */
    @Test
    public void testGetUserByUsername_whenNotEmpty() {
        Users exampleUsers = new Users("mthayer2","Matt","Thayer","ExamplePass123");
       
       Optional<Users> expResult = Optional.of(exampleUsers);
       doReturn(expResult).when(UsersRepository).findById("mthayer2");
       
       Optional<Users> actualResult = usersService.getUser("mthayer2");
       
       assertEquals(expResult,actualResult);
    }
    
}
