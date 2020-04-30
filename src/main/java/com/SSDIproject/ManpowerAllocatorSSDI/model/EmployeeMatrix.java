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

/**
 *
 * @author kolby
 */
@Entity
public class EmployeeMatrix {
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer entry_id;
      private Integer employee_id;
      private Integer job_id;
      private Integer job_knowledge;
      public EmployeeMatrix(){}

    public EmployeeMatrix(Integer entry_id, Integer employee_id, Integer job_id, Integer job_knowledge) {
        this.entry_id = entry_id;
        this.employee_id = employee_id;
        this.job_id = job_id;
        this.job_knowledge = job_knowledge;
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getJob_knowledge() {
        return job_knowledge;
    }

    public void setJob_knowledge(Integer job_knowledge) {
        this.job_knowledge = job_knowledge;
    }
      
}
