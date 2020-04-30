/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.EmployeeMatrix;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kolby
 */
public class EmployeeMatrixServiceTest {
    
    public EmployeeMatrixServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addEmployeeMatrix method, of class EmployeeMatrixService.
     */
    @Test
    public void testAddEmployeeMatrix() {
        System.out.println("addEmployeeMatrix");
        EmployeeMatrix jt = null;
        EmployeeMatrixService instance = new EmployeeMatrixService();
        boolean expResult = false;
        boolean result = instance.addEmployeeMatrix(jt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of updateEmployeeMatrix method, of class EmployeeMatrixService.
     */
    @Test
    public void testUpdateEmployeeMatrix() {
        System.out.println("updateEmployeeMatrix");
        Integer id = null;
        EmployeeMatrix jt = null;
        EmployeeMatrixService instance = new EmployeeMatrixService();
        boolean expResult = false;
        boolean result = instance.updateEmployeeMatrix(id, jt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployeeMatrix method, of class EmployeeMatrixService.
     */
    @Test
    public void testGetAllEmployeeMatrix() {
        System.out.println("getAllEmployeeMatrix");
        EmployeeMatrixService instance = new EmployeeMatrixService();
        Iterable<EmployeeMatrix> expResult = null;
        Iterable<EmployeeMatrix> result = instance.getAllEmployeeMatrix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeMatrix method, of class EmployeeMatrixService.
     */
    @Test
    public void testGetEmployeeMatrix() {
        System.out.println("getEmployeeMatrix");
        Integer id = null;
        EmployeeMatrixService instance = new EmployeeMatrixService();
        Optional<EmployeeMatrix> expResult = null;
        Optional<EmployeeMatrix> result = instance.getEmployeeMatrix(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployeeMatrix method, of class EmployeeMatrixService.
     */
    @Test
    public void testDeleteEmployeeMatrix() {
        System.out.println("deleteEmployeeMatrix");
        Integer id = null;
        EmployeeMatrixService instance = new EmployeeMatrixService();
        boolean expResult = false;
        boolean result = instance.deleteEmployeeMatrix(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
