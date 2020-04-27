/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.AttendanceService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import java.lang.reflect.Array;

import java.time.LocalDate;
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
@RequestMapping(path="/attendance")
@CrossOrigin
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;

	// Add new job type
	@PostMapping(path="/add")
	public @ResponseBody String addNewAttendance (@RequestBody Attendance a) {
		return attendanceService.addAttendance(a);
	}
	
	// Get all job types
	@GetMapping(path="/all")
	public @ResponseBody ResponseEntity<Iterable<Attendance>> getAllAttendance() {
            AttendanceService as = new AttendanceService();
            Iterable<Attendance> allAList;
            allAList = as.getAllAttendance();
		return new ResponseEntity<>(allAList,
                HttpStatus.OK);
	}
        @GetMapping(path="/absence")
	public @ResponseBody Iterable<Attendance> getAllAbsenceCodes() {
		return attendanceService.getAllAbsenceCodes();
	}
        
        @GetMapping(path="/today")
	public @ResponseBody Iterable<Attendance> getTodaysAttendance(String date) {
		return attendanceService.getTodaysAttendance(date);
	}
	
       
	// Get single job type by Id
	@GetMapping(path="/{id}")
	public @ResponseBody ResponseEntity<Optional<Attendance>> getAttendanceById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(attendanceService.getAttendance(id),HttpStatus.OK);
	}
	
	// Update a Job Type
	@PostMapping(path="/update")
	public String updateAttendance(@RequestBody 
        Attendance a) {
		return attendanceService.updateAttendance(a);
	}

	
	// Delete a Attendance
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteAttendance(@PathVariable(name = "id") Integer id) {
		return attendanceService.deleteAttendance(id);
	}
}
