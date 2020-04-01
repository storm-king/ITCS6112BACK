/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.RankingRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
        
        
	
	// Add new Ranking
	public boolean addRanking(Ranking rank) {
		
		try {
			rankingRepository.save(rank);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Ranking
	public boolean updateRanking(Integer id, Ranking rank) {
		try {
			rank.setRankId(id);
			rankingRepository.save(rank);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Rankings
	public Iterable<Ranking> getAllRankings(){
		return rankingRepository.findAll();
	}

	
	// Get single Ranking by Id
	public Optional<Ranking> getRanking(Integer id) {
		return rankingRepository.findById(id);
	}

	
}
