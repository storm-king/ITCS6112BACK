/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.AttendanceRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	// Add new Job Type
	public String addAttendance(Attendance a) {
		
		try {
			attendanceRepository.save(a);
			return "saved";
		} catch(Exception e) {
			return "failed";
		}
	}


        // Update a Job Type
	public String updateAttendance(Attendance a) {
		try {
//                     List<Attendance> attendanceList = new ArrayList<>();
//                     at.forEach(attendanceList::add);
//			
//                     a.setAbsence_Date(attendanceList.get(0).getAbsence_date());
//                     a.setId(2);
//                     System.out.println(attendanceList.get(0).getId());
//                     a.setEmployee_id(attendanceList.get(0).getEmployee_id());
//                     a.setHours_Missed(attendanceList.get(0).getHours_missed());
                     
                       
			attendanceRepository.save(a);
			return "Updated";
		}catch(Exception e) {
			return "Failed";
		}
	}


	// Get all Job Types
	public Iterable<Attendance> getAllAttendance(){
	 
            return attendanceRepository.findAll();
	}
        public Iterable<Attendance> getTodaysAttendance(String date){
	//  LocalDate today = LocalDate.now();
//            DateFormat f1 = new SimpleDateFormat("MM/dd/yyyy");
//            String holdDate = date.toString();
//            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//            date = f1.parse(date.toString());
//          String subDate;
//            subDate = date.substring(8,17);
        LocalDate localDate = LocalDate.parse(date);
       
         
           Iterable<Attendance> a;
            a = attendanceRepository.getAll();
           List<Attendance> attendanceList = new ArrayList<>();
          a.forEach(attendanceList::add);
          
          
          Iterator<Attendance> itr = attendanceList.iterator();
                  
                  while(itr.hasNext()){
                      Attendance loan = itr.next();
                      LocalDate holder = loan.getAbsence_date();
                      if(localDate.compareTo(holder)!=0){
                          System.out.println(loan.getId() + " " + loan.getEmployee_id());
                          itr.remove();
                      }
                          
                  }
      
        
           
            return attendanceList;
	}
      
      
	
	// Get single Job Type by Id
	public Optional<Attendance> getAttendance(Integer id) {
		return attendanceRepository.findById(id);
	}

	
	// Delete a Job Type
	public String deleteAttendance(Integer id) {
		try{
			attendanceRepository.deleteById(id);
			return "Deleted";
		}catch(Exception e) {
			return "Failed";
		}
	}

	
}
