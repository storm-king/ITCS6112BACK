/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;


import com.SSDIproject.ManpowerAllocatorSSDI.Services.EmployeeService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kolby
 */
@Controller
@RequestMapping(path="/employee")
@CrossOrigin
public class EmployeeController {
    
   @Autowired 
   private EmployeeService employeeService;
    @PostMapping(path="/add")
	public @ResponseBody String addNewEmployee (@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}
        
         @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<Employee>> getAllEmployee() {
        Iterable<Employee> employeeList = employeeService.getAllEmployee();
        return new ResponseEntity<>(
                employeeList,
                HttpStatus.OK);
    }
    
}
