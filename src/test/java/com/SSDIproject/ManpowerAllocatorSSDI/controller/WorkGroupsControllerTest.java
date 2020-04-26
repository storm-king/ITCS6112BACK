package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.WorkGroupsService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.WorkGroups;
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
public class WorkGroupsControllerTest {
    
    @InjectMocks
    WorkGroupsController workGroupsController;
    
    @Mock
    WorkGroupsService workGroupsService;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(workGroupsController).build();
    }
    
    /**
     * Test Success of getAllWorkGroups method, of class JobsController.
     */
    @Test
    public void testGetAllWorkGroups_request_OK()
    {
        WorkGroups workGroup1 = new WorkGroups(1, "test1");
        WorkGroups workGroup2 = new WorkGroups(2, "test2");
        
        WorkGroups[] workGroupList = {workGroup1, workGroup2};
        List<WorkGroups> workGroupsList = new ArrayList<WorkGroups>();
        workGroupsList.add(workGroup1);
        workGroupsList.add(workGroup1);
        Iterable<WorkGroups> allWorkGroupsList = workGroupsList;
        
        doReturn(allWorkGroupsList).when(workGroupsService).getAllWorkGroups();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/work_groups/all")
                    .content(asJsonString(allWorkGroupsList))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of getWorkGroupsId method, of class WorkGroupsController.
     */
    @Test
    public void testGetWorkGroupsById_request_OK()
    {
        WorkGroups workGroup1 = new WorkGroups(1, "test1");
        
        Optional<WorkGroups> workGroup = Optional.of(workGroup1);
        
        doReturn(workGroup).when(workGroupsService).getWorkGroup(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/work_groups/{id}", "1")
                    .content(asJsonString(workGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of getWorkGroupsId method, of class WorkGroupsController.
     */
    @Test
    public void testGetWorkGroupsById_request_Not_Found()
    {     
        Optional<WorkGroups> emptyWorkGroup = Optional.empty();
        
        doReturn(emptyWorkGroup).when(workGroupsService).getWorkGroup(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/work_groups/{id}", "1")
                    .content(asJsonString(emptyWorkGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }  

    /**
     * Test Success of addNewWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testAddNewWorkGroup_request_OK()
    {
        WorkGroups workGroup = new WorkGroups(1, "test1");
        
        doReturn(true).when(workGroupsService).addWorkGroup(any(WorkGroups.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/work_groups/add")
                    .content(asJsonString(workGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of addNewWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testAddNewWorkGroup_request_Internal_Server_Error()
    {
        WorkGroups workGroup = new WorkGroups(1, "test1");
        
        doReturn(false).when(workGroupsService).addWorkGroup(any(WorkGroups.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/work_groups/add")
                    .content(asJsonString(workGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of updateWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testUpdateWorkGroup_request_OK()
    {
        WorkGroups workGroup = new WorkGroups(1, "test1");
        
        doReturn(true).when(workGroupsService).updateWorkGroup(anyInt(), any(WorkGroups.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/work_groups/update/{id}", "1")
                    .content(asJsonString(workGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of updateWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testUpdateWorkGroup_request_Internal_Server_Error()
    {
        WorkGroups workGroup = new WorkGroups(1, "test1");
        
        doReturn(false).when(workGroupsService).updateWorkGroup(anyInt(), any(WorkGroups.class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/work_groups/update/{id}", "2")
                    .content(asJsonString(workGroup))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Success of deleteWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testDeleteWorkGroup_request_Ok()
    {   
        String successMessage = "Successfully Deleted!";
        
        doReturn(true).when(workGroupsService).deleteWorkGroup(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/work_groups/delete/{id}", "1")
                    .content(asJsonString(successMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
    /**
     * Test Failure of deleteWorkGroup method, of class WorkGroupsController.
     */
    @Test
    public void testDeleteWorkGroup_request_Internal_Server_Error()
    {   
        String failMessage = "Failure Deleting";
        
        doReturn(false).when(workGroupsService).deleteWorkGroup(anyInt());

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/work_groups/delete/{id}", "1")
                    .content(asJsonString(failMessage))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isInternalServerError())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(WorkGroupsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
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
