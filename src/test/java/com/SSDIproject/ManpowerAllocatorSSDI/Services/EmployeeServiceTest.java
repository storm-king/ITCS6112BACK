/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.EmployeeRepository;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.EmployeeRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;

/**
 *
 * @author kolby
 */
public class EmployeeServiceTest {
       @InjectMocks
    EmployeeService employeeService;
    
    @Mock
    EmployeeRepository employeeRepository;
    
    public EmployeeServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addEmployees method, of class EmployeeService.
     */
    
}
