/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.RankingService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Add new ranking
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Ranking> addNewRanking(@RequestBody Ranking rank) {
        boolean status = rankingService.addRanking(rank);
        //Return OK status if successfully updated
        if (status) {
            return new ResponseEntity<>(
                    rank,
                    HttpStatus.OK);
        }
        //Otherwise, return server error if something went wrong
        return new ResponseEntity<>(
                rank,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Get all rankings
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<Ranking>> getAllRankings() {
        Iterable<Ranking> rankingsList = rankingService.getAllRankings();
        return new ResponseEntity<>(
                rankingsList,
                HttpStatus.OK);
    }

    // Get single ranking by Id
    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Optional<Ranking>> getRankingsById(@PathVariable(name = "id") Integer id) {
        Optional<Ranking> ranking = rankingService.getRanking(id);
        //If Found, return OK status with ranking found
        if (ranking.isPresent()) {
            return new ResponseEntity<>(
                    ranking,
                    HttpStatus.OK);
        }
        //Otherwise, return error not found
        return new ResponseEntity<>(
                ranking,
                HttpStatus.NOT_FOUND);
    }

    // Update a Ranking
    @PostMapping(path = "/update/{id}")
    public @ResponseBody
    ResponseEntity<Ranking> updateRanking(@PathVariable(name = "id") Integer id, @RequestBody Ranking rank) {
        boolean status = rankingService.updateRanking(id, rank);
        //If Successful update, return OK Status
        if (status) {
            return new ResponseEntity<>(
                    rank,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                rank,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
