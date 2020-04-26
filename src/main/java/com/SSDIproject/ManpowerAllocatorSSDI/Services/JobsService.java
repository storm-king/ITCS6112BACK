/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobsRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {
	
	@Autowired
	private JobsRepository jobsRepository;
        
        
	
	// Add new Job Type
	public boolean addJob(Jobs job) {
		
		try {
			jobsRepository.save(job);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job
	public boolean updateJob(Integer id, Jobs job) {
		try {
			job.setJobId(id);
			jobsRepository.save(job);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Jobs
	public Iterable<Jobs> getAllJobs(){
		return jobsRepository.findAll();
	}

	
	// Get single Job by Id
	public Optional<Jobs> getJob(Integer id) {
		return jobsRepository.findById(id);
	}

	
	// Delete a Job
	public boolean deleteJob(Integer id) {
		try{
			jobsRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
