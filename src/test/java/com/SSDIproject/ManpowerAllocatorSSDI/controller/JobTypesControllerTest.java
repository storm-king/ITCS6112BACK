/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobTypesService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author matthewthayer
 */

@ExtendWith(MockitoExtension.class)
public class JobTypesControllerTest {
    
    @InjectMocks
    JobTypesController jobTypesController;
    
    @Mock
    JobTypesService jobTypesService;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(jobTypesController).build();
    }
    
    /**
     * Test Success of getAllJobTypes method, of class JobsController.
     */
    @Test
    public void testGetAllJobTypes_request_OK()
    {
        JobTypes jobType1 = new JobTypes(1, "test1");
        JobTypes jobType2 = new JobTypes(2, "test2");
        
        JobTypes[] jobList = {jobType1, jobType2};
        List<JobTypes> jobTypesList = new ArrayList<JobTypes>();
        jobTypesList.add(jobType1);
        jobTypesList.add(jobType1);
        Iterable<JobTypes> allJobTypesList = jobTypesList;
        
        doReturn(allJobTypesList).when(jobTypesService).getAllJobTypes();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/job_types/all")
                    .content(asJsonString(allJobTypesList))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of getJobTypesId method, of class JobsController.
     */
    @Test
    public void testGetJobTypesById_request_OK()
    {
        JobTypes jobType1 = new JobTypes(1, "test1");
        
        Optional<JobTypes> jobType = Optional.of(jobType1);
        
        doReturn(jobType).when(jobTypesService).getJobType(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/job_types/{id}", "1")
                    .content(asJsonString(jobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of getJobTypesId method, of class JobsController.
     */
    @Test
    public void testGetJobTypesById_request_Not_Found()
    {     
        Optional<JobTypes> emptyJobType = Optional.empty();
        
        doReturn(emptyJobType).when(jobTypesService).getJobType(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/job_types/{id}", "1")
                    .content(asJsonString(emptyJobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }  

    /**
     * Test Success of addNewJobType method, of class JobsController.
     */
    @Test
    public void testAddNewJobType_request_OK()
    {
        JobTypes jobType = new JobTypes(1, "test1");
        
        doReturn(true).when(jobTypesService).addJobType(any(JobTypes.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/job_types/add")
                    .content(asJsonString(jobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of addNewJobType method, of class JobsController.
     */
    @Test
    public void testAddNewJobType_request_Internal_Server_Error()
    {
        JobTypes jobType = new JobTypes(1, "test1");
        
        doReturn(false).when(jobTypesService).addJobType(any(JobTypes.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/job_types/add")
                    .content(asJsonString(jobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of updateJobType method, of class JobsController.
     */
    @Test
    public void testUpdateJobType_request_OK()
    {
        JobTypes jobType = new JobTypes(1, "test1");
        
        doReturn(true).when(jobTypesService).updateJobType(anyInt(), any(JobTypes.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/job_types/update/{id}", "1")
                    .content(asJsonString(jobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of updateJobType method, of class JobsController.
     */
    @Test
    public void testUpdateJobType_request_Internal_Server_Error()
    {
        JobTypes jobType = new JobTypes(1, "test1");
        
        doReturn(false).when(jobTypesService).updateJobType(anyInt(), any(JobTypes.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/job_types/update/{id}", "2")
                    .content(asJsonString(jobType))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of deleteJobType method, of class JobsController.
     */
    @Test
    public void testDeleteJobType_request_Ok()
    {   
        String successMessage = "Successfully Deleted!";
        
        doReturn(true).when(jobTypesService).deleteJobType(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/job_types/delete/{id}", "1")
                    .content(asJsonString(successMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of deleteJobType method, of class JobsController.
     */
    @Test
    public void testDeleteJobType_request_Internal_Server_Error()
    {   
        String failMessage = "Failure Deleting";
        
        doReturn(false).when(jobTypesService).deleteJobType(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/job_types/delete/{id}", "1")
                    .content(asJsonString(failMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }

    
    //Helper Method to turn Objects into JSON String
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
