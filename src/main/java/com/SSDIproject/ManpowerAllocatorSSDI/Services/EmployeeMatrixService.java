/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.EmployeeMatrix;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.EmployeeMatrixRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMatrixService {
	
	@Autowired
	private EmployeeMatrixRepository employeeMatrixRepository;
        
        
	
	// Add new Job Type
	public boolean addEmployeeMatrix(EmployeeMatrix jt) {
		
		try {
			employeeMatrixRepository.save(jt);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job Type
	public boolean updateEmployeeMatrix(Integer id, EmployeeMatrix jt) {
		try {
			jt.setEntry_id(id);
			employeeMatrixRepository.save(jt);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Job Types
	public Iterable<EmployeeMatrix> getAllEmployeeMatrix(){
		return employeeMatrixRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<EmployeeMatrix> getEmployeeMatrix(Integer id) {
		return employeeMatrixRepository.findById(id);
	}

	
	// Delete a Job Type
	public boolean deleteEmployeeMatrix(Integer id) {
		try{
			employeeMatrixRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
