/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kolby
 */
@Entity
public class Attendance {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

     
     private Integer employee_id;
     private LocalDate absence_date;
     private float hours_missed;
     private Integer code_id;

    public Integer getCode_id() {
        return code_id;
    }

    public void setCode_id(Integer code_id) {
        this.code_id = code_id;
    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public LocalDate getAbsence_date() {
        return absence_date;
    }

    public void setAbsence_Date(LocalDate absence_date) {
        this.absence_date = absence_date;
    }

    public float getHours_missed() {
        return hours_missed;
    }

    public void setHours_Missed(float hours_missed) {
        this.hours_missed = hours_missed;
    }
     
     
    
}
