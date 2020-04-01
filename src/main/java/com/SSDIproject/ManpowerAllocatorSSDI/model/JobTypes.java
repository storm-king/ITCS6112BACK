/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class JobTypes {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     
    private String typeName;
    
    @OneToMany(mappedBy="jobType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Ranking> ranks;
    
    public JobTypes(){
        
    }
 
    public JobTypes(int id, String typeName){
        this.id = id;
        this.typeName = typeName;
    }
    
    
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getTypeName() {
        return typeName;
    }
 
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
         
}