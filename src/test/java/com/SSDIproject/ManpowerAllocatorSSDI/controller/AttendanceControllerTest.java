/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kolby
 */
public class AttendanceControllerTest {
    
    public AttendanceControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addNewAttendance method, of class AttendanceController.
     */
    @Test
    public void testAddNewAttendance() {
        System.out.println("addNewAttendance");
        Attendance a = new Attendance();
        AttendanceController instance = new AttendanceController();
        String expResult = "";
        String result = instance.addNewAttendance(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getAllAttendance method, of class AttendanceController.
     */
    @Test
    public void testGetAllAttendance() {
        System.out.println("getAllAttendance");
        AttendanceController instance = new AttendanceController();
        Iterable<Attendance> expResult = null;
        Iterable<Attendance> result = instance.getAllAttendance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getTodaysAttendance method, of class AttendanceController.
     */
    @Test
    public void testGetTodaysAttendance() {
        System.out.println("getTodaysAttendance");
        AttendanceController instance = new AttendanceController();
        Iterable<Attendance> expResult = null;
        Iterable<Attendance> result = instance.getTodaysAttendance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAttendanceById method, of class AttendanceController.
     */
    @Test
    public void testGetAttendanceById() {
        System.out.println("getAttendanceById");
        Integer id = null;
        AttendanceController instance = new AttendanceController();
        Optional<Attendance> expResult = null;
        Optional<Attendance> result = instance.getAttendanceById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of updateAttendance method, of class AttendanceController.
     */
    @Test
    public void testUpdateAttendance() {
        System.out.println("updateAttendance");
        Integer id = null;
        Attendance a = null;
        AttendanceController instance = new AttendanceController();
        String expResult = "";
        String result = instance.updateAttendance(id, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteAttendance method, of class AttendanceController.
     */
    @Test
    public void testDeleteAttendance() {
        System.out.println("deleteAttendance");
        Integer id = null;
        AttendanceController instance = new AttendanceController();
        String expResult = "";
        String result = instance.deleteAttendance(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
