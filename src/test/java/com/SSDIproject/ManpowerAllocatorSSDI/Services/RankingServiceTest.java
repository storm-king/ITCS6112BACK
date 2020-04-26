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
 * @author mthayer
 */
@ExtendWith(MockitoExtension.class)
public class RankingServiceTest {
     
    //@InjectMocks
    //JobTypesService jobTypesService;
    @InjectMocks
    RankingService rankingService;
    
    @Mock JobTypesRepository jobTypesRepository;
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
        Optional<JobTypes> testJtOptional = Optional.of(new JobTypes(1, "testJob"));
        JobTypes testJt = new JobTypes(1, "testJob");
        
        Ranking r1 = new Ranking(1, testJt, 1, 1);
        Ranking r2 = new Ranking(2, testJt, 2, 2);
        Ranking[] rList = {r1, r2};
        
        //Mock
        doReturn(r1).when(rankingRepository).save(any(Ranking.class));  
        doReturn(testJtOptional).when(jobTypesRepository).findById(any(Integer.class));
        
        //Test results
        boolean result = rankingService.updateAllRankings(rList);
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
    public void testGetAllRankings_Empty_DB() {
        Iterable<Ranking> emptyIterable = new ArrayList<Ranking>();
        
        doReturn(emptyIterable).when(rankingRepository).findAll();
        
        Iterable<Ranking> expResult = emptyIterable;
        Iterable<Ranking> result = rankingService.getAllRankings();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllRankings method, of class RankingService.
     */
    @Test
    public void testGetAllRankings_DB_Has_Entries() {
        ArrayList<Ranking> rList = new ArrayList<Ranking>();
        rList.add(new Ranking(1, 1, 1));
        rList.add(new Ranking(2, 2, 2));
        Iterable<Ranking> rankingList = rList;
        doReturn(rankingList).when(rankingRepository).findAll();
        
        Iterable<Ranking> expResult = rankingList;
        Iterable<Ranking> result = rankingService.getAllRankings();
        assertEquals(expResult, result);
    }
    
}
