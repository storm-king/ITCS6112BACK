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
 * @author kolby
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer employee_id;
    
        public String first_name;
         public String last_name;
        public  int job_type_id;
        public LocalDate seniority_date;
         public int shift;
         public Employee(){};

    public Employee(Integer  employee_id, String first_name, String last_name, int job_type_id, LocalDate seniority_date, int shift) {
     
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_type_id = job_type_id;
        this.seniority_date = seniority_date;
        this.shift = shift;
    }

    public Integer getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(Integer id) {
        this.employee_id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getJob_type_id() {
        return job_type_id;
    }

    public void setJob_type_id(int job_type_id) {
        this.job_type_id = job_type_id;
    }

    public LocalDate getSeniority_date() {
        return seniority_date;
    }

    public void setSeniority_date(LocalDate seniority_date) {
        this.seniority_date = seniority_date;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
    
         
        

   

  

   

  
}
