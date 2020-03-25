/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobTypesRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTypesService {
	
	@Autowired
	private JobTypesRepository jobTypeRepository;
	
	// Add new Job Type
	public String addJobType(JobTypes jt) {
		
		try {
			jobTypeRepository.save(jt);
			return "saved";
		} catch(Exception e) {
			return "failed";
		}
	}


        // Update a Job Type
	public String updateJobType(Integer id, JobTypes jt) {
		try {
			jt.setId(id);
			jobTypeRepository.save(jt);
			return "Updated";
		}catch(Exception e) {
			return "Failed";
		}
	}


	// Get all Job Types
	public Iterable<JobTypes> getAllJobTypes(){
		return jobTypeRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<JobTypes> getJobType(Integer id) {
		return jobTypeRepository.findById(id);
	}

	
	// Delete a Job Type
	public String deleteJobType(Integer id) {
		try{
			jobTypeRepository.deleteById(id);
			return "Deleted";
		}catch(Exception e) {
			return "Failed";
		}
	}

	
}
