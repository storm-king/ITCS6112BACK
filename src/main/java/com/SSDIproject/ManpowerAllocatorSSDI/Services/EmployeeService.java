/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kolby
 */
@Service
public class EmployeeService {
        @Autowired
    	private EmployeeRepository employeeRepository;
 
        public String addEmployees(Employee em) {
		
		try {
			employeeRepository.save(em);
			return "saved";
		} catch(Exception e) {
			return "failed";
		}
	}
    
}
