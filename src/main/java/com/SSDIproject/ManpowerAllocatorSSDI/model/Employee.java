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
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     public int employee_id;
        public String first_name;
         public String last_name;
        public String position;
        public boolean first_shift;
         public boolean second_shift;
         public boolean third_shift;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isFirst_shift() {
        return first_shift;
    }

    public void setFirst_shift(boolean first_shift) {
        this.first_shift = first_shift;
    }

    public boolean isSecond_shift() {
        return second_shift;
    }

    public void setSecond_shift(boolean second_shift) {
        this.second_shift = second_shift;
    }

    public boolean isThird_shift() {
        return third_shift;
    }

    public void setThird_shift(boolean third_shift) {
        this.third_shift = third_shift;
    }

  

   

  
}
