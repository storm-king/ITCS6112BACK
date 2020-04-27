/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Jobs {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer jobId;
     
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="groupId", nullable=false)
    @JsonBackReference
    private WorkGroups groupId;

    private String jobName;
    
    public Jobs(){
        
    }
    
    //This is a constructor only used for testing purposes
    public Jobs(Integer id, String name)
    {
        jobId = id;
        jobName = name;
    }
    
    public Integer getJobId(){
        return jobId;
    }
    
    public void setJobId(Integer newId){
        jobId = newId;
    }
    
    public WorkGroups getGroupId(){
        return groupId;
    }
    
    public void setGroupId(WorkGroups wg){
        groupId = wg;
    }
    
    public String getJobName(){
        return jobName;
    }
    
    public void setJobName(String newJobName){
        jobName = newJobName;
    }
    
}
