/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.AttendanceCodes;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.AttendanceCodeRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceCodeService {
	
	@Autowired
	private AttendanceCodeRepository attendanceCodeRepository;
        
        
	
	// Add new Job Type
	public boolean addAttendanceCode(AttendanceCodes jt) {
		
		try {
			attendanceCodeRepository.save(jt);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job Type
	public boolean updateAttendanceCode(Integer id, AttendanceCodes jt) {
		try {
			jt.setCode_id(id);
			attendanceCodeRepository.save(jt);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Job Types
	public Iterable<AttendanceCodes> getAllAttendanceCodes(){
		return attendanceCodeRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<AttendanceCodes> getAttendanceCode(Integer id) {
		return attendanceCodeRepository.findById(id);
	}

	
	// Delete a Job Type
	public boolean deleteAttendanceCode(Integer id) {
		try{
			attendanceCodeRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
