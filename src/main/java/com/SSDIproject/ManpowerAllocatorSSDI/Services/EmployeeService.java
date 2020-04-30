/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;

import com.SSDIproject.ManpowerAllocatorSSDI.repository.EmployeeRepository;
import java.util.Optional;
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
 
        public String addEmployee(Employee em) {
		
		try {
			employeeRepository.save(em);
			return "saved";
		} catch(Exception e) {
			return "failed";
		}
	}
        public Optional<Employee> getEmployee(Integer id) {
		return employeeRepository.findById(id);
	}
        public boolean updateEmployee(Integer id, Employee jt) {
		try {
			jt.setEmployeeId(id);
			employeeRepository.save(jt);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
        	public Iterable<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
    
}
