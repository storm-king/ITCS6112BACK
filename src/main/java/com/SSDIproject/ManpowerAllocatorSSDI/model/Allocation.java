/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;



import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author storm
 */
@Entity
public class Allocation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer entryId;
    
    private Integer jobId;
    private Integer employeeId;
    private String entryDate;
    private String firstName;
    private String lastName;
    private String jobName;
         
    public Allocation(){};

    public Integer getEntryId(){
        return entryId;
    }
    
    public void setEntryId(int id){
        this.entryId = id;
    }
    
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer id) {
        this.jobId = id;
    }
    
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer id) {
        this.employeeId = id;
    }

    public String getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(String date) {
        this.entryDate = date;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setJobName(String jobName){
        this.jobName = jobName;
    }
    
    public String getJobName(){
        return this.jobName;
    }
}
