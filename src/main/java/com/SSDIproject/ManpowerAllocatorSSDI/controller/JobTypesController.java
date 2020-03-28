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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = "/job_types")
@CrossOrigin
public class JobTypesController {

    @Autowired
    private JobTypesService JobTypesService;

    // Add new job type
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<String> addNewJobType(@RequestBody JobTypes jt) {
        String status = JobTypesService.addJobType(jt);
        //Return OK status if successfully updated
        if (status.equals("saved")) {
            return new ResponseEntity<String>(
                    status,
                    HttpStatus.OK);
        }
        //Otherwise, return server error if something went wrong
        return new ResponseEntity<String>(
                status,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Get all job types
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<JobTypes>> getAllJobTypes() {
        Iterable<JobTypes> jobTypesList = JobTypesService.getAllJobTypes();
        return new ResponseEntity<Iterable<JobTypes>>(
                jobTypesList,
                HttpStatus.OK);
    }

    // Get single job type by Id
    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Optional<JobTypes>> getJobTypesById(@PathVariable(name = "id") Integer id) {
        Optional<JobTypes> jobType = JobTypesService.getJobType(id);
        //If Found, return OK status with job type found
        if (jobType.isPresent()) {
            return new ResponseEntity<Optional<JobTypes>>(
                    jobType,
                    HttpStatus.OK);
        }
        //Otherwise, return error not found
        return new ResponseEntity<Optional<JobTypes>>(
                jobType,
                HttpStatus.NOT_FOUND);
    }

    // Update a Job Type
    @PostMapping(path = "/update/{id}")
    public @ResponseBody
    ResponseEntity<String> updateJobType(@PathVariable(name = "id") Integer id, @RequestBody JobTypes jt) {
        String status = JobTypesService.updateJobType(id, jt);
        //If Successful update, return OK Status
        if (status.equals("Updated")) {
            return new ResponseEntity<String>(
                    status,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<String>(
                status,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Delete a JobType
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteJobType(@PathVariable(name = "id") Integer id) {
        String status = JobTypesService.deleteJobType(id);
        //If Successfully Deleted, Return OK status
        if (status.equals("Deleted")) {
            return new ResponseEntity<String>(
                    status,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<String>(
                status,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
