/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobsService;
import com.SSDIproject.ManpowerAllocatorSSDI.Services.RankingService;
import static com.SSDIproject.ManpowerAllocatorSSDI.controller.JobsControllerTest.asJsonString;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
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
 * @author stormking
 */
@ExtendWith(MockitoExtension.class)
public class RankingControllerTest {
    
    @InjectMocks
    RankingController rankingController;
    
    @Mock
    RankingService rankingService;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rankingController).build();
    }
    
    /**
     * Test Success of getAllRankings method, of class RankingController.
     */
    @Test
    public void testGetAllRankings_request_OK()
    {
        Ranking r1 = new Ranking(1, 1, 1);
        Ranking r2 = new Ranking(2, 2, 2);
        
        Ranking[] rList = {r1, r2};
        List<Ranking> rankingList = new ArrayList<Ranking>();
        rankingList.add(r1);
        rankingList.add(r1);
        Iterable<Ranking> allRankingsList = rankingList;
        
        doReturn(allRankingsList).when(rankingService).getAllRankings();

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/ranking/all")
                    .content(asJsonString(allRankingsList))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(RankingControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
        /**
     * Test Success of updateRanking method, of class RankingController.
     */
    @Test
    public void testUpdateRanking_request_OK()
    {
        Ranking r1 = new Ranking(1, 1, 1);
        Ranking rList[] = {r1};
        
        doReturn(true).when(rankingService).updateAllRankings(any(Ranking[].class));

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/ranking/update_all")
                    .content(asJsonString(rList))
                    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"));
        } catch (Exception ex) {
            Logger.getLogger(JobsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    
}
