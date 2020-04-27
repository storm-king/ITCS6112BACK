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
 
@Entity
public class Jobs {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer job_id;
     private Integer group_id;
    private String job_name;
    
    public Jobs(){
        
    }

    public Jobs(Integer job_id, Integer group_id, String job_name) {
        this.job_id = job_id;
        this.group_id = group_id;
        this.job_name = job_name;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }
 
    
         
}