/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
     
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="job_type", nullable=false)
    @JsonBackReference
    private JobTypes jobType;

    private Integer knowLvl;
    private Integer importance;
    
    public Ranking(){
        
    }
    
     //This is a constructor only used for testing purposes
    public Ranking(Integer id, Integer kl, Integer imp)
    {
        rankId = id;
        knowLvl = kl;
        importance = imp;   
    }
    
    //Constructor created for testing purposes:
    public Ranking(Integer id, JobTypes jt, Integer know, Integer importance){
        this.rankId = id;
        this.jobType = jt;
        this.knowLvl = know;
        this.importance = importance;
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
    
    public Integer getImportance(){
        return importance;
    }
    
    public void setImportance(Integer newRank){
        importance = newRank;
    }
    
    public JobTypes getJobType(){
        return jobType;
    }
    
    public void setJobType(JobTypes jt){
        jobType = jt;
    }
    
}
