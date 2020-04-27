/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Components;

import com.SSDIproject.ManpowerAllocatorSSDI.Services.AttendanceService;
import com.SSDIproject.ManpowerAllocatorSSDI.Services.JobsService;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author stormking
 */
//@Component
//public class Allocator {
    
//    private HashMap<Integer, Employee> allEmployees;
//    private ArrayList<Employee> presentEmployees;
//    private ArrayList<Jobs> allJobs;
//    
//    @Autowired
//    private AttendanceService attendanceService;
//    
//    @Autowired
//    private EmployeeService employeeService;
//    
//    @Autowired
//    private JobsService jobsService;
//    
//    public Allocator(){
//        allEmployees = getAllEmployees();
//        presentEmployees = getEmployeesPresent(allEmployees);   
//        allJobs = getAllJobs();
//    }
//    
//    private void Allocate(ArrayList<Employee> presentEmployees, ArrayList<Jobs> jobs){
//        int numberOfEmployees = presentEmployees.size();
//        int numberOfJobs = allJobs.size();
//        
//    }
//    
//    //TODO: Write method to get all employees
//    private HashMap<Integer, Employee> getAllEmployees(){
//        HashMap<Integer, Employee> employeeMap = new HashMap<>();
//        Iterable<Employee> employees = employeeService.getAllEmployees();
//        
//        for(Employee employee : employees){
//            employeeList.put(employee.getId(), employee);
//        }
//        
//        return employeeMap;
//    }
//    
//    private ArrayList<Employee> getEmployeesPresent(HashMap<Integer, Employee> employeeList){
//        // Get Today's Date
//        Date today = Calendar.getInstance().getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(today);
//        // Get All Absences for today
//        Iterable<Attendance> todaysAbsences = attendanceService.getTodaysAttendance(date);
//        // Iterate through employees, removing ones with entries in the attendance table
//        for(Attendance record: todaysAbsences){
//            employeeList.remove(record.getEmployee_id());
//        }
//        
//        Collection<Employee> values = employeeList.values();
//        ArrayList<Employee> listOfPresentEmployees = new ArrayList<>(values);
//        
//        return listOfPresentEmployees;      
//    }
//    
//    private ArrayList<Jobs> getAllJobs(){
//        ArrayList<Jobs> jobsList = new ArrayList<>();
//        Iterable<Jobs> jobs = jobsService.getAllJobs();
//        for(Jobs job : jobs){
//            jobsList.add(job);
//        }
//        return jobsList;
//    }
    
    
    
//}
