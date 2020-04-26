/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobTypesRepository;
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
public class JobTypesServiceTest {
    
    @InjectMocks
    JobTypesService jobTypesService;
    
    @Mock JobTypesRepository jobTypesRepository;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
    }

    /**
     * Test of addJobType method, of class JobTypesService.
     */
    @Test
    public void testAddJobType() {
        JobTypes jt = new JobTypes(1, "test1");
        
        doReturn(jt).when(jobTypesRepository).save(any(JobTypes.class));

        boolean expResult = true;
        boolean result = jobTypesService.addJobType(jt);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of updateJobType method, of class JobTypesService.
     */
//    @Test
//    public void testUpdateJobType_ID_Present() {
//        Integer id = 1;
//        JobTypes jt = new JobTypes(1, "test1");
//        JobTypes newJt = new JobTypes(1, "test");
//        
//        doReturn(newJt).when(jobTypesRepository).save(any(JobTypes.class));
//        
//        boolean expResult = true;
//        boolean result = jobTypesService.updateJobType(id, jt);
//        assertEquals(expResult, result);
//    }
    
    /**
     * Test of updateJobType method, of class JobTypesService.
     */
    @Test
    public void testUpdateJobType_ID_Exception() {
        Integer id = 1;
                
        boolean expResult = false;
        //Passing empty object should throw exception, causing false return
        boolean result = jobTypesService.updateJobType(id, null);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllJobTypes method, of class JobTypesService.
     */
    @Test
    public void testGetAllJobTypes_Empty_DB() {
        Iterable<JobTypes> emptyIterable = new ArrayList<JobTypes>();
        
        doReturn(emptyIterable).when(jobTypesRepository).findAll();
        
        Iterable<JobTypes> expResult = emptyIterable;
        Iterable<JobTypes> result = jobTypesService.getAllJobTypes();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllJobTypes method, of class JobTypesService.
     */
    @Test
    public void testGetAllJobTypes_DB_Has_Entries() {
        ArrayList<JobTypes> jtList = new ArrayList<JobTypes>();
        jtList.add(new JobTypes(1, "test1"));
        jtList.add(new JobTypes(2, "test2"));
        Iterable<JobTypes> jobTypesList = jtList;
        doReturn(jobTypesList).when(jobTypesRepository).findAll();
        
        Iterable<JobTypes> expResult = jobTypesList;
        Iterable<JobTypes> result = jobTypesService.getAllJobTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJobType method, of class JobTypesService.
     */
    @Test
    public void testGetJobType_JobType_Exists() {
        Integer id = 1;
        Optional<JobTypes> jt = Optional.of(new JobTypes(1, "test1"));
        
        doReturn(jt).when(jobTypesRepository).findById(anyInt());
        
        Optional<JobTypes> expResult = jt;
        Optional<JobTypes> result = jobTypesService.getJobType(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getJobType method, of class JobTypesService.
     */
    @Test
    public void testGetJobType_JobType_Does_Not_Exist() {
        Integer id = 1;
        Optional<JobTypes> emptyOptional = Optional.empty();
        
        doReturn(emptyOptional).when(jobTypesRepository).findById(anyInt());
        
        Optional<JobTypes> expResult = emptyOptional;
        Optional<JobTypes> result = jobTypesService.getJobType(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteJobType method, of class JobTypesService.
     */
    @Test
    public void testDeleteJobType_JobType_Exists() {
        Integer id = 1;
        JobTypes jt = new JobTypes(1, "test1");
        
        //doNothing().when(jobTypesRepository).delete(jt);
        
        boolean expResult = true;
        boolean result = jobTypesService.deleteJobType(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteJobType method, of class JobTypesService.
     */
    @Test
    public void testDeleteJobType_JobType_Does_Not_Exist() {
        Integer id = 1;
        
        doThrow(new RecoverableDataAccessException("Not found")).when(jobTypesRepository).deleteById(anyInt());
        
        boolean expResult = false;
        boolean result = jobTypesService.deleteJobType(id);
        assertEquals(expResult, result);
    }
    
}
