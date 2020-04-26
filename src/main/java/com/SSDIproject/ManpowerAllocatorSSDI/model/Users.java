/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Users {
 
    //Setting global variables for my user table in database
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String username;
     
    private String firstName;
    
    private String lastName;
    
    private String password;
    
    //defult constructor with no params
    public Users(){
        
    }
    
    //overloaded constructor with params that initilize fields
    public Users(String username, String firstname, String lastName, String password)
    {
        this.username = username;
        this.firstName = firstname;
        this.lastName = lastName;
        this.password = password;
    }
    
    //getters and setters for all colums in database
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
 
    public void setTypeName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
         
}

