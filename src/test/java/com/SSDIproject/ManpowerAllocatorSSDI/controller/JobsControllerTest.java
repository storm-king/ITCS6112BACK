package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobsService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
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
public class JobsControllerTest {
    
    @InjectMocks
    JobsController jobsController;
    
    @Mock
    JobsService jobsService;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(jobsController).build();
    }
    
    /**
     * Test Success of getAllJobs method, of class JobsController.
     */
    @Test
    public void testGetAllJobs_request_OK()
    {
        Jobs job1 = new Jobs(1, "test1");
        Jobs job2 = new Jobs(2, "test2");
        
        Jobs[] jobList = {job1, job2};
        List<Jobs> jobsList = new ArrayList<Jobs>();
        jobsList.add(job1);
        jobsList.add(job1);
        Iterable<Jobs> allJobsList = jobsList;
        
        doReturn(allJobsList).when(jobsService).getAllJobs();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/jobs/all")
                    .content(asJsonString(allJobsList))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of getJobsId method, of class JobsController.
     */
    @Test
    public void testGetJobsById_request_OK()
    {
        Jobs job1 = new Jobs(1, "test1");
        
        Optional<Jobs> job = Optional.of(job1);
        
        doReturn(job).when(jobsService).getJob(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/jobs/{id}", "1")
                    .content(asJsonString(job))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobTypesControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of getJobsId method, of class JobsController.
     */
    @Test
    public void testGetJobsById_request_Not_Found()
    {     
        Optional<Jobs> emptyJob = Optional.empty();
        
        doReturn(emptyJob).when(jobsService).getJob(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/jobs/{id}", "1")
                    .content(asJsonString(emptyJob))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }  

    /**
     * Test Success of addNewJob method, of class JobsController.
     */
    @Test
    public void testAddNewJobType_request_OK()
    {
        Jobs job = new Jobs(1, "test1");
        
        doReturn(true).when(jobsService).addJob(any(Jobs.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/jobs/add")
                    .content(asJsonString(job))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of addNewJob method, of class JobsController.
     */
    @Test
    public void testAddNewJob_request_Internal_Server_Error()
    {
        Jobs job = new Jobs(1, "test1");
        
        doReturn(false).when(jobsService).addJob(any(Jobs.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/jobs/add")
                    .content(asJsonString(job))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of updateJob method, of class JobsController.
     */
    @Test
    public void testUpdateJob_request_OK()
    {
        Jobs job = new Jobs(1, "test1");
        
        doReturn(true).when(jobsService).updateJob(anyInt(), any(Jobs.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/jobs/update/{id}", "1")
                    .content(asJsonString(job))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of updateJob method, of class JobsController.
     */
    @Test
    public void testUpdateJob_request_Internal_Server_Error()
    {
        Jobs job = new Jobs(1, "test1");
        
        doReturn(false).when(jobsService).updateJob(anyInt(), any(Jobs.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/jobs/update/{id}", "2")
                    .content(asJsonString(job))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of deleteJob method, of class JobsController.
     */
    @Test
    public void testDeleteJob_request_Ok()
    {   
        String successMessage = "Successfully Deleted!";
        
        doReturn(true).when(jobsService).deleteJob(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/jobs/delete/{id}", "1")
                    .content(asJsonString(successMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of deleteJobmethod, of class JobsController.
     */
    @Test
    public void testDeleteJob_request_Internal_Server_Error()
    {   
        String failMessage = "Failure Deleting";
        
        doReturn(false).when(jobsService).deleteJob(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/jobs/delete/{id}", "1")
                    .content(asJsonString(failMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
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
