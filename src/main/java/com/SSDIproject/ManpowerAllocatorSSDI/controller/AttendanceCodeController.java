/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.AttendanceCodeService;

import com.SSDIproject.ManpowerAllocatorSSDI.model.AttendanceCodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kolby
 */
@Controller
@RequestMapping(path = "/attendance_code")
@CrossOrigin
public class AttendanceCodeController {
    
     @Autowired
    private AttendanceCodeService AttendanceCodeService;
    
     @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<AttendanceCodes>> getAllAttendanceCodes() {
        Iterable<AttendanceCodes> jobTypesList = AttendanceCodeService.getAllAttendanceCodes();
        return new ResponseEntity<>(
                jobTypesList,
                HttpStatus.OK);
    }
    
}
