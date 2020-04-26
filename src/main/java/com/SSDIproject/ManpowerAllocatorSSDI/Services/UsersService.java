/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Users;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.UsersRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    
    // Authenticate user by passing username and password as parameters.
    //If the database is not empty then get user by username and check to see
    //if that username's cooresponding password is the same as the password passed in
    //else return false.
    public boolean authenticateUser(String username, String password) {
        Optional<Users> user = getUser(username);
        if (user.isPresent()) {
            Users existingUsers = user.get();
            String correctPassword = existingUsers.getPassword();
            return correctPassword.equals(password);
        }
        return false;
    }

    // Get single User by username and return the user 
    public Optional<Users> getUser(String username) {
        return usersRepository.findById(username);
    }

}
