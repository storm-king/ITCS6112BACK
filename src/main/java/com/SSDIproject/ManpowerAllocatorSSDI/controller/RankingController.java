/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.RankingService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/ranking")
@CrossOrigin
public class RankingController {

    @Autowired
    private RankingService rankingService;

    // Get all rankings
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<Ranking>> getAllRankings() {
        Iterable<Ranking> rankingsList = rankingService.getAllRankings();
        return new ResponseEntity<>(
                rankingsList,
                HttpStatus.OK);
    }

    // Update all Rankings
    @PostMapping(path = "/update_all")
    public @ResponseBody
    ResponseEntity<Ranking[]> updateAllRanking(@RequestBody Ranking[] ranks) {
        boolean status = rankingService.updateAllRankings(ranks);
        //If Successful update, return OK Status
        if (status) {
            return new ResponseEntity<>(
                    ranks,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                ranks,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
