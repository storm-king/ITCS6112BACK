package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.WorkGroupsService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.WorkGroups;
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
@RequestMapping(path = "/work_groups")
@CrossOrigin
public class WorkGroupsController {

    @Autowired
    private WorkGroupsService WorkGroupsService;

    // Add new job type
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<WorkGroups> addNewWorkGroup(@RequestBody WorkGroups wg) {
        boolean status = WorkGroupsService.addWorkGroup(wg);
        //Return OK status if successfully updated
        if (status) {
            return new ResponseEntity<>(
                    wg,
                    HttpStatus.OK);
        }
        //Otherwise, return server error if something went wrong
        return new ResponseEntity<>(
                wg,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Get all job types
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<WorkGroups>> getAllWorkGroups() {
        Iterable<WorkGroups> workGroupsList = WorkGroupsService.getAllWorkGroups();
        return new ResponseEntity<>(
                workGroupsList,
                HttpStatus.OK);
    }

    // Get single job type by Id
    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Optional<WorkGroups>> getWorkGroupsById(@PathVariable(name = "id") Integer id) {
        Optional<WorkGroups> workGroup = WorkGroupsService.getWorkGroup(id);
        //If Found, return OK status with job type found
        if (workGroup.isPresent()) {
            return new ResponseEntity<>(
                    workGroup,
                    HttpStatus.OK);
        }
        //Otherwise, return error not found
        return new ResponseEntity<>(
                workGroup,
                HttpStatus.NOT_FOUND);
    }

    // Update a Job Type
    @PostMapping(path = "/update/{id}")
    public @ResponseBody
    ResponseEntity<WorkGroups> updateWorkGroup(@PathVariable(name = "id") Integer id, @RequestBody WorkGroups wg) {
        boolean status = WorkGroupsService.updateWorkGroup(id, wg);
        //If Successful update, return OK Status
        if (status) {
            return new ResponseEntity<>(
                    wg,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                wg,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Delete a JobType
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteWorkGroup(@PathVariable(name = "id") Integer id) {
        boolean status = WorkGroupsService.deleteWorkGroup(id);
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