/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.AllocationService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Allocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/allocation")
@CrossOrigin
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    // Get all rankings
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<Allocation>> getAllocatedEmployees() {
        Iterable<Allocation> allocationList = allocationService.getAllocation();
        return new ResponseEntity<>(
                allocationList,
                HttpStatus.OK);
    }

}