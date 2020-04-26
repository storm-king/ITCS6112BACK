/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author stormking
 */
public class RankingControllerTest {
    
    public RankingControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRankings method, of class RankingController.
     */
    @Test
    public void testGetAllRankings() {
        System.out.println("getAllRankings");
        RankingController instance = new RankingController();
        ResponseEntity<Iterable<Ranking>> expResult = null;
        ResponseEntity<Iterable<Ranking>> result = instance.getAllRankings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAllRanking method, of class RankingController.
     */
    @Test
    public void testUpdateAllRanking() {
        System.out.println("updateAllRanking");
        Ranking[] ranks = null;
        RankingController instance = new RankingController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.updateAllRanking(ranks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
