/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.UsersService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Users;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UsersService usersService;

    // authenticating user, if username and password combination are correct that pass as OK status else throw UNAUTHORIZED status
    @PostMapping(path = "/authenticate")
    public @ResponseBody
    ResponseEntity<Optional<Users>> authenticateUser(@RequestBody Users user) {   
     Optional<Users> userFound = null;
     if(usersService.authenticateUser(user.getUsername(), user.getPassword())){
         userFound = usersService.getUser(user.getUsername());
         return new ResponseEntity<>(
          userFound, 
          HttpStatus.OK);
     }
     return new ResponseEntity<>(
          userFound, 
          HttpStatus.UNAUTHORIZED);
    }
}
