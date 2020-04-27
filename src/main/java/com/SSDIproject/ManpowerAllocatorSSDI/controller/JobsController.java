/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobsService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
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
@RequestMapping(path = "/job")
@CrossOrigin
public class JobsController {

    @Autowired
    private JobsService JobsService;

    // Add new job type
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Jobs> addNewJob(@RequestBody Jobs jt) {
        boolean status = JobsService.addJob(jt);
        //Return OK status if successfully updated
        if (status) {
            return new ResponseEntity<>(
                    jt,
                    HttpStatus.OK);
        }
        //Otherwise, return server error if something went wrong
        return new ResponseEntity<>(
                jt,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Get all job types
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<Jobs>> getAllJobs() {
        Iterable<Jobs> jobsList = JobsService.getAllJobs();
        return new ResponseEntity<>(
                jobsList,
                HttpStatus.OK);
    }

    // Get single job type by Id
    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Optional<Jobs>> getJobsById(@PathVariable(name = "id") Integer id) {
        Optional<Jobs> jobType = JobsService.getJob(id);
        //If Found, return OK status with job type found
        if (jobType.isPresent()) {
            return new ResponseEntity<>(
                    jobType,
                    HttpStatus.OK);
        }
        //Otherwise, return error not found
        return new ResponseEntity<>(
                jobType,
                HttpStatus.NOT_FOUND);
    }

    // Update a Job Type
    @PostMapping(path = "/update/{id}")
    public @ResponseBody
    ResponseEntity<Jobs> updateJob(@PathVariable(name = "id") Integer id, @RequestBody Jobs jt) {
        boolean status = JobsService.updateJob(id, jt);
        //If Successful update, return OK Status
        if (status) {
            return new ResponseEntity<>(
                    jt,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                jt,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Delete a Job
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteJob(@PathVariable(name = "id") Integer id) {
        boolean status = JobsService.deleteJob(id);
        //If Successfully Deleted, Return OK status
        if (status) {
            return new ResponseEntity<>(
                    "Successfully Deleted!",
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                "Failure Deleting",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
