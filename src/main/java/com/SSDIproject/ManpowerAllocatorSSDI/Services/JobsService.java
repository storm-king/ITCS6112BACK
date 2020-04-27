/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobsRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
	
	@Autowired
	private JobsRepository jobTypeRepository;
        
        
	
	// Add new Job Type
	public boolean addJob(Jobs jt) {
		
		try {
			jobTypeRepository.save(jt);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job Type
	public boolean updateJob(Integer id, Jobs jt) {
		try {
			jt.setJob_id(id);
			jobTypeRepository.save(jt);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Job Types
	public Iterable<Jobs> getAllJobs(){
		return jobTypeRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<Jobs> getJob(Integer id) {
		return jobTypeRepository.findById(id);
	}

	
	// Delete a Job Type
	public boolean deleteJob(Integer id) {
		try{
			jobTypeRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
