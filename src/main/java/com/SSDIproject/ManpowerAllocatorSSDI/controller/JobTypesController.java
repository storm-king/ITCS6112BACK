/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobTypesService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/job_types")
@CrossOrigin
public class JobTypesController {
	
	@Autowired
	private JobTypesService jobTypesService;
	
	// Add new job type
	@PostMapping(path="/add")
	public @ResponseBody String addNewJobType (@RequestBody JobTypes jt) {
		return jobTypesService.addJobType(jt);
	}
	
	// Get all job types
	@GetMapping(path="/all")
	public @ResponseBody Iterable<JobTypes> getAllJobTypes() {
		return jobTypesService.getAllJobTypes();
	}
	
	// Get single job type by Id
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<JobTypes> getJobTypesById(@PathVariable(name = "id") Integer id) {
		return jobTypesService.getJobType(id);
	}
	
	// Update a Job Type
	@PostMapping(path="/update/{id}")
	public @ResponseBody String updateJobType(@PathVariable(name = "id") Integer id, @RequestBody 
        JobTypes jt) {
		return jobTypesService.updateJobType(id,jt);
	}

	
	// Delete a JobType
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteJobType(@PathVariable(name = "id") Integer id) {
		return jobTypesService.deleteJobType(id);
	}
}
