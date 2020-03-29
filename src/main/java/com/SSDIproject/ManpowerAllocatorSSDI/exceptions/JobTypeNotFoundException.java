/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class JobTypeNotFoundException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    public JobTypeNotFoundException() {
        super("Job Type does not exist");
    }
 
}
