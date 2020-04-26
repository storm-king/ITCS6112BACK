/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class WorkGroups {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     
    private String workGroupName;
    
    @OneToMany(mappedBy="groupId", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<Jobs> jobs = null;
    
    public WorkGroups(){
        
    }
 
    public WorkGroups(int id, String typeName){
        this.id = id;
        this.workGroupName = workGroupName;
    }
    
    
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getWorkGroupName() {
        return workGroupName;
    }
 
    public void setWorkGroupName(String typeName) {
        this.workGroupName = typeName;
    }
    
    public void setJobs(Set<Jobs> jobs) {
        if (this.jobs == null) {
            this.jobs = jobs;
        } else if(this.jobs != jobs) {
            this.jobs.clear();
            if(jobs != null){
                this.jobs.addAll(jobs);
            }
        }
    }
    
    public Set<Jobs> getJobs(){
        return jobs;
    }
         
}