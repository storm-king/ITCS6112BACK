/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.controller.AttendanceController;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.AttendanceRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author kolby
 */
@ExtendWith(MockitoExtension.class)
public class AttendanceServiceTest {
    
    public AttendanceServiceTest() {
    }
    
     @InjectMocks
    AttendanceService attendanceService;
    
    @Mock
    AttendanceRepository AttendanceRepository;
    
    @BeforeEach
    public void setUp() {
        initMocks(this);
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAttendance method, of class AttendanceService.
     */
    @Test
    public void testAddAttendance() {
        LocalDate testDate = LocalDate.parse("2020-03-28");
        Attendance a = new Attendance(9,25,testDate, (float) 1.15,2);
        AttendanceController instance = new AttendanceController();
        attendanceService.addAttendance(a);
        Optional<Attendance> expResult = Optional.of(a);
        doReturn(expResult).when(AttendanceRepository).findById(a.getId());
        Optional<Attendance> actualResult = attendanceService.getAttendance(a.getId());
        
        
        assertEquals(expResult, actualResult);
 
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of updateAttendance method, of class AttendanceService.
     */
    @Test
    public void testUpdateAttendance() {
          LocalDate testDate = LocalDate.parse("2020-03-28");
        Attendance a = new Attendance(9,25,testDate, (float) 1.15,2);
        AttendanceController instance = new AttendanceController();
        
       Optional<Attendance> expResult = Optional.of(a);
        
       attendanceService.updateAttendance(a);
           
       
       doReturn(expResult).when(AttendanceRepository).findById(a.getId());
        Optional<Attendance> actualResult = attendanceService.getAttendance(a.getId());
        
        
        assertEquals(expResult, actualResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getAllAttendance method, of class AttendanceService.
     */
    @Test
    public void testGetAllAttendance() {
        System.out.println("getAllAttendance");
      Iterable<Attendance>test= attendanceService.getAllAttendance();
      Iterable<Attendance>test1= AttendanceRepository.findAll();
      
      assertEquals(test,test1);
      
      
    }

    /**
     * Test of getAllAbsenceCodes method, of class AttendanceService.
     */
    @Test
    public void testGetAllAbsenceCodes() {
        System.out.println("getAllAttendance");
      Iterable<Attendance>test= attendanceService.getAllAbsenceCodes();
      Iterable<Attendance>test1= AttendanceRepository.getAbsenceCodes();
      
      assertEquals(test,test1);
    }

    /**
     * Test of getTodaysAttendance method, of class AttendanceService.
     */
    @Test
    public void testGetTodaysAttendance() {
        System.out.println("getAllAttendance");
      Iterable<Attendance>test= attendanceService.getTodaysAttendance("2020-03-28");
      Iterable<Attendance>test1;
      
      LocalDate localDate = LocalDate.parse("2020-03-28");
       
         
           Iterable<Attendance> a;
            a = AttendanceRepository.getAll();
           List<Attendance> attendanceList = new ArrayList<>();
          a.forEach(attendanceList::add);
          
          
          Iterator<Attendance> itr = attendanceList.iterator();
                  
                  while(itr.hasNext()){
                      Attendance loan = itr.next();
                      LocalDate holder = loan.getAbsence_date().plusDays(1);
                      if(localDate.compareTo(holder)!=0){
                          System.out.println(loan.getId() + " " + loan.getEmployee_id());
                          itr.remove();
                      }
                      else{
                          loan.setAbsence_Date(loan.getAbsence_date().plusDays(1));
                      }
                          
                  }
      
        test1= attendanceList;
      
      assertEquals(test,test1);
    }

    /**
     * Test of getAttendance method, of class AttendanceService.
     */
    @Test
    public void testGetAttendance() {
        LocalDate testDate = LocalDate.parse("2020-03-28");
        Attendance a = new Attendance(9,25,testDate, (float) 1.15,2);
        AttendanceRepository.save(a);
       Optional<Attendance> test = attendanceService.getAttendance(a.getId());
        Optional<Attendance> test1 = AttendanceRepository.findById(a.getId());
        
        assertEquals(test, test1);
       
    }

    /**
     * Test of deleteAttendance method, of class AttendanceService.
     */
    @Test
    public void testDeleteAttendance() {
         LocalDate testDate = LocalDate.parse("2020-03-28");
        Attendance a = new Attendance(9,25,testDate, (float) 1.15,2);
        AttendanceRepository.save(a);
        attendanceService.deleteAttendance(a.getId());
        Optional<Attendance> expResult = Optional.of(a);
        doReturn(expResult).when(AttendanceRepository).findById(a.getId());
        Optional<Attendance> actualResult = attendanceService.getAttendance(a.getId());
        
        
        assertEquals(expResult, actualResult);
    }
    
}
