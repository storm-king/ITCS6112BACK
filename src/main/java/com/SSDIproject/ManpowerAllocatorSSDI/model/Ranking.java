/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Ranking {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer rankId;
     
    @ManyToOne
    @JoinColumn(name="job_type", nullable=false)
    private JobTypes jobType;

    private Integer knowLvl;
    private Integer rank;
    
    public Ranking(){
        
    }
    
    public Integer getRankId(){
        return rankId;
    }
    
    public void setRankId(Integer newId){
        rankId = newId;
    }
    
    public Integer getKnowLvl(){
        return knowLvl;
    }
    
    public void setKnowLvl(Integer newKnowLvl){
        knowLvl = newKnowLvl;
    }
    
    public Integer getRank(){
        return rank;
    }
    
    public void setRank(Integer newRank){
        rank = newRank;
    }
    
    public JobTypes getJobType(){
        return jobType;
    }
    
    public void setJobType(JobTypes jt){
        jobType = jt;
    }
}
