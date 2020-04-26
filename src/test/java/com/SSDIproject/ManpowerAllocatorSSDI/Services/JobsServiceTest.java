/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobsRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.RecoverableDataAccessException;

/**
 *
 * @author matthewthayer
 */

@ExtendWith(MockitoExtension.class)
public class JobsServiceTest {
    
    @InjectMocks
    JobsService jobsService;
    
    @Mock JobsRepository jobsRepository;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
    }

    /**
     * Test of addJob method, of class JobsService.
     */
    @Test
    public void testAddJob() {
        Jobs j = new Jobs(1, "test1");
        
        doReturn(j).when(jobsRepository).save(any(Jobs.class));

        boolean expResult = true;
        boolean result = jobsService.addJob(j);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateJob method, of class JobsService.
     */
    @Test
    public void testUpdateJob_ID_Exception() {
        Integer id = 1;
                
        boolean expResult = false;
        //Passing empty object should throw exception, causing false return
        boolean result = jobsService.updateJob(id, null);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllJobs method, of class JobsService.
     */
    @Test
    public void testGetAllJobs_Empty_DB() {
        Iterable<Jobs> emptyIterable = new ArrayList<Jobs>();
        
        doReturn(emptyIterable).when(jobsRepository).findAll();
        
        Iterable<Jobs> expResult = emptyIterable;
        Iterable<Jobs> result = jobsService.getAllJobs();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllJobs method, of class JobsService.
     */
    @Test
    public void testGetAllJobs_DB_Has_Entries() {
        ArrayList<Jobs> jList = new ArrayList<Jobs>();
        jList.add(new Jobs(1, "test1"));
        jList.add(new Jobs(2, "test2"));
        Iterable<Jobs> jobsList = jList;
        doReturn(jobsList).when(jobsRepository).findAll();
        
        Iterable<Jobs> expResult = jobsList;
        Iterable<Jobs> result = jobsService.getAllJobs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJob method, of class JobsService.
     */
    @Test
    public void testGetJob_Job_Exists() {
        Integer id = 1;
        Optional<Jobs> j = Optional.of(new Jobs(1, "test1"));
        
        doReturn(j).when(jobsRepository).findById(anyInt());
        
        Optional<Jobs> expResult = j;
        Optional<Jobs> result = jobsService.getJob(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getJob method, of class JobsService.
     */
    @Test
    public void testGetJob_Job_Does_Not_Exist() {
        Integer id = 1;
        Optional<Jobs> emptyOptional = Optional.empty();
        
        doReturn(emptyOptional).when(jobsRepository).findById(anyInt());
        
        Optional<Jobs> expResult = emptyOptional;
        Optional<Jobs> result = jobsService.getJob(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteJob method, of class JobsService.
     */
    @Test
    public void testDeleteJob_Job_Exists() {
        Integer id = 1;
        Jobs j = new Jobs(1, "test1");
        
        //doNothing().when(jobsRepository).delete(j);
        
        boolean expResult = true;
        boolean result = jobsService.deleteJob(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteJob method, of class JobsService.
     */
    @Test
    public void testDeleteJob_Job_Does_Not_Exist() {
        Integer id = 1;
        
        doThrow(new RecoverableDataAccessException("Not found")).when(jobsRepository).deleteById(anyInt());
        
        boolean expResult = false;
        boolean result = jobsService.deleteJob(id);
        assertEquals(expResult, result);
    }
    
}