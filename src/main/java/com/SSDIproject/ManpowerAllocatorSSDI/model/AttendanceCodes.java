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
public class AttendanceCodes {
         @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer code_id;
         private String reason;

    public AttendanceCodes() {
    }

    public AttendanceCodes(Integer code_id, String reason) {
        this.code_id = code_id;
        this.reason = reason;
    }

    public Integer getCode_id() {
        return code_id;
    }

    public void setCode_id(Integer code_id) {
        this.code_id = code_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
