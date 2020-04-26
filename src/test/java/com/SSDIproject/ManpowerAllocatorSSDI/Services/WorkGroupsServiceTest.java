package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.WorkGroups;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.WorkGroupsRepository;
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
public class WorkGroupsServiceTest {
    
    @InjectMocks
   WorkGroupsService workGroupsService;
    
    @Mock WorkGroupsRepository workGroupsRepository;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
    }

    /**
     * Test of addJobType method, of class WorkGroupsService.
     */
    @Test
    public void testAddWorkGroup() {
        WorkGroups wg = new WorkGroups(1, "test1");
        
        doReturn(wg).when(workGroupsRepository).save(any(WorkGroups.class));

        boolean expResult = true;
        boolean result = workGroupsService.addWorkGroup(wg);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateWorkGroup method, of class WorkGroupsService.
     */
    @Test
    public void testUpdateWorkGroup_ID_Exception() {
        Integer id = 1;
                
        boolean expResult = false;
        //Passing empty object should throw exception, causing false return
        boolean result = workGroupsService.updateWorkGroup(id, null);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllWorkGroups method, of class WorkGroupsService.
     */
    @Test
    public void testGetAllWorkGroups_Empty_DB() {
        Iterable<WorkGroups> emptyIterable = new ArrayList<WorkGroups>();
        
        doReturn(emptyIterable).when(workGroupsRepository).findAll();
        
        Iterable<WorkGroups> expResult = emptyIterable;
        Iterable<WorkGroups> result = workGroupsService.getAllWorkGroups();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllWorkGroups method, of class WorkGroupsService.
     */
    @Test
    public void testGetAllWorkGroups_DB_Has_Entries() {
        ArrayList<WorkGroups> wgList = new ArrayList<WorkGroups>();
        wgList.add(new WorkGroups(1, "test1"));
        wgList.add(new WorkGroups(2, "test2"));
        Iterable<WorkGroups> workGroupsList = wgList;
        doReturn(workGroupsList).when(workGroupsRepository).findAll();
        
        Iterable<WorkGroups> expResult = workGroupsList;
        Iterable<WorkGroups> result = workGroupsService.getAllWorkGroups();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWorkGroup method, of class WorkGroupsService.
     */
    @Test
    public void testGetWorkGroup_WorkGroup_Exists() {
        Integer id = 1;
        Optional<WorkGroups> wg = Optional.of(new WorkGroups(1, "test1"));
        
        doReturn(wg).when(workGroupsRepository).findById(anyInt());
        
        Optional<WorkGroups> expResult = wg;
        Optional<WorkGroups> result = workGroupsService.getWorkGroup(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getWorkGroup method, of class WorkGroupsService.
     */
    @Test
    public void testGetWorkGroup_WorkGroup_Does_Not_Exist() {
        Integer id = 1;
        Optional<WorkGroups> emptyOptional = Optional.empty();
        
        doReturn(emptyOptional).when(workGroupsRepository).findById(anyInt());
        
        Optional<WorkGroups> expResult = emptyOptional;
        Optional<WorkGroups> result = workGroupsService.getWorkGroup(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteWorkGroup method, of class WorkGroupsService.
     */
    @Test
    public void testDeleteWorkGroup_WorkGroup_Exists() {
        Integer id = 1;
        WorkGroups wg = new WorkGroups(1, "test1");
        
        //doNothing().when(workGroupsRepository).delete(wg);
        
        boolean expResult = true;
        boolean result = workGroupsService.deleteWorkGroup(id);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteWorkGroup method, of class WorkGroupsService.
     */
    @Test
    public void testDeleteWorkGroup_WorkGroup_Does_Not_Exist() {
        Integer id = 1;
        
        doThrow(new RecoverableDataAccessException("Not found")).when(workGroupsRepository).deleteById(anyInt());
        
        boolean expResult = false;
        boolean result = workGroupsService.deleteWorkGroup(id);
        assertEquals(expResult, result);
    }
    
}