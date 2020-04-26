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
	public boolean addJobType(JobTypes jt) {
		
		try {
			jobTypeRepository.save(jt);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job Type
	public boolean updateJobType(Integer id, JobTypes jt) {
		try {
                        Optional<JobTypes> previous = jobTypeRepository.findById(id);
                        JobTypes previousJobType = previous.get();
                        jt.setId(id);
                        jt.setRanks(previousJobType.getRanks());
			jobTypeRepository.save(jt);
			return true;
		}catch(Exception e) {
                        System.out.println(e);
			return false;
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
	public boolean deleteJobType(Integer id) {
		try{
			jobTypeRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
