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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
        
        @Autowired
	private JobTypesRepository jobTypeRepository;
        
        // Update all Rankings
	public boolean updateAllRankings(Ranking[] ranks) {
		try {
                        rankingRepository.deleteAll();
                        if(ranks.length == 0){
                            return false;
                        }
                        for(Ranking rank : ranks){ 
                            JobTypes jobTypeFK = 
                            jobTypeRepository.findById(rank.getJobType().getId()).get();
                            rank.setJobType(jobTypeFK);
                            System.out.println(rank.getClass());
                            rankingRepository.save(rank);
                        };
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Rankings
	public Iterable<Ranking> getAllRankings(){
		return rankingRepository.findAll();
	}	
}
