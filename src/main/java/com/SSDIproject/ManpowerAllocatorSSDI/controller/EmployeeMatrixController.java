/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.controller;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.EmployeeMatrixService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.EmployeeMatrix;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/employee_matrix")
@CrossOrigin
public class EmployeeMatrixController {

    @Autowired
    private EmployeeMatrixService EmployeeMatrixService;

    // Add new job type
    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<EmployeeMatrix> addNewEmployeeMatrix(@RequestBody EmployeeMatrix jt) {
        boolean status = EmployeeMatrixService.addEmployeeMatrix(jt);
        //Return OK status if successfully updated
        if (status) {
            return new ResponseEntity<>(
                    jt,
                    HttpStatus.OK);
        }
        //Otherwise, return server error if something went wrong
        return new ResponseEntity<>(
                jt,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Get all job types
    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<Iterable<EmployeeMatrix>> getAllEmployeeMatrix() {
        Iterable<EmployeeMatrix> employeeMatrixsList = EmployeeMatrixService.getAllEmployeeMatrix();
        return new ResponseEntity<>(
                employeeMatrixsList,
                HttpStatus.OK);
    }

    // Get single job type by Id
    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<Optional<EmployeeMatrix>> getEmployeeMatrixById(@PathVariable(name = "id") Integer id) {
        Optional<EmployeeMatrix> employeeMatrix = EmployeeMatrixService.getEmployeeMatrix(id);
        //If Found, return OK status with job type found
        if (employeeMatrix.isPresent()) {
            return new ResponseEntity<>(
                    employeeMatrix,
                    HttpStatus.OK);
        }
        //Otherwise, return error not found
        return new ResponseEntity<>(
                employeeMatrix,
                HttpStatus.NOT_FOUND);
    }

    // Update a Job Type
    @PostMapping(path = "/update/{id}")
    public @ResponseBody
    ResponseEntity<EmployeeMatrix> updateEmployeeMatrix(@PathVariable(name = "id") Integer id, @RequestBody EmployeeMatrix jt) {
        boolean status = EmployeeMatrixService.updateEmployeeMatrix(id, jt);
        //If Successful update, return OK Status
        if (status) {
            return new ResponseEntity<>(
                    jt,
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                jt,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Delete a EmployeeMatrix
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteEmployeeMatrix(@PathVariable(name = "id") Integer id) {
        boolean status = EmployeeMatrixService.deleteEmployeeMatrix(id);
        //If Successfully Deleted, Return OK status
        if (status) {
            return new ResponseEntity<>(
                    "Successfully Deleted!",
                    HttpStatus.OK);
        }
        //Otherwise, return server error
        return new ResponseEntity<>(
                "Failure Deleting",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
