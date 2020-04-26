/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobTypesRepository;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.RankingRepository;
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
 * @author stormking
 */
@ExtendWith(MockitoExtension.class)
public class RankingServiceTest {
     
    //@InjectMocks
    //JobTypesService jobTypesService;
    @InjectMocks
    RankingService rankingService;
    
    //@Mock JobTypesRepository jobTypesRepository;
    @Mock RankingRepository rankingRepository;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
    }

    /**
     * Test of updateAllRankings method, of class RankingService.
     * TODO: MOCK THE JOBTYPESREPOSITORY.FINDBYID for this to work
     */
    @Test
    public void testUpdateAllRankings_RankingsPassedInSuccessfully() {
        System.out.println("updateAllRankings");
        
        //Setup
        JobTypes exampleJob = new JobTypes(1, "test");
        Ranking testRank1 = new Ranking(1, exampleJob, 1, 1);
        Ranking testRank2 = new Ranking(2, exampleJob, 2, 2);
        Ranking[] ranks = {testRank1, testRank2};
        
        //Mock
        doReturn(testRank1).when(rankingRepository).save(any(Ranking.class));
        
        //Test results
        boolean result = rankingService.updateAllRankings(ranks);
        boolean expResult = true;
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateAllRankings method, of class RankingService.
     */
    @Test
    public void testUpdateAllRankings_RankingsPassedInUnsuccessfully() {
        System.out.println("updateAllRankings");
        
        //Setup
        Ranking[] ranks = {};
        
        //Test results
        boolean result = rankingService.updateAllRankings(ranks);
        boolean expResult = false;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllRankings method, of class RankingService.
     */
    @Test
    public void testGetAllRankings() {
        
    }
    
}
