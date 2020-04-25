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
public class WorkGroups {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     
    private String workGroupName;
    
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
         
}