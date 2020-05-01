/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Allocation;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Attendance;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Employee;
import com.SSDIproject.ManpowerAllocatorSSDI.model.EmployeeMatrix;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Ranking;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.AllocationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {
	
    @Autowired
    private AllocationRepository allocationRepository;
    
    @Autowired
    private AttendanceService attendanceService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private JobsService jobsService;
    
    @Autowired
    private RankingService rankingService;
    
    @Autowired
    private EmployeeMatrixService employeeMatrixService;
    
    public Iterable<Allocation> getAllocation(){
        HashMap<Integer, Employee> allEmployees = getAllEmployees();
        ArrayList<Employee> presentEmployees = getEmployeesPresent(allEmployees);
        presentEmployees = orderEmployeesBySeniority(presentEmployees);
        
        ArrayList<Jobs> allJobs = getAllJobs();
        ArrayList<Ranking> allRankings = getAllRankings();
        ArrayList<EmployeeMatrix> allMatrices = getAllEmployeeMatrices();
        
        int[][] edmondsMatrix = 
                createEdmondsMatrix(presentEmployees, allMatrices, allJobs, allRankings);
        
        int[] employeeAssignments = maxBPM(edmondsMatrix, allJobs.size(), allEmployees.size());
        
        for(int assignmentIndex = 0; assignmentIndex < allJobs.size(); assignmentIndex++){
            if(employeeAssignments[assignmentIndex] != -1){
                int assignment = employeeAssignments[assignmentIndex];
                Allocation allocatedEmployeeEntry = new Allocation();
                
                // Set employee Id of assignment
                Employee employeeAssigned = presentEmployees.get(assignment);
                allocatedEmployeeEntry.setEmployeeId(employeeAssigned.getEmployeeId());
                
                // Set first and last name of assignment
                allocatedEmployeeEntry.setFirstName(employeeAssigned.getFirst_name());
                allocatedEmployeeEntry.setLastName(employeeAssigned.getLast_name());
                
                // Set job Id of assignment
                Jobs jobAssigned = allJobs.get(assignmentIndex);
                allocatedEmployeeEntry.setJobId(jobAssigned.getJobId());
                
                // Set job name of assignment
                allocatedEmployeeEntry.setJobName(jobAssigned.getJobName());
                
                // Set entry date of assignment
                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(today);
                allocatedEmployeeEntry.setEntryDate(date);
                
                // Save entry to DB
                allocationRepository.save(allocatedEmployeeEntry);
            }
            // If it is unassigned indicate that in the db as well
            else{
                Allocation allocatedEmployeeEntry = new Allocation();
                
                // Set Employee info to ID: -1 First and Last: UNASSIGNED
                allocatedEmployeeEntry.setEmployeeId(-1);
                allocatedEmployeeEntry.setFirstName("UNASSIGNED");
                allocatedEmployeeEntry.setLastName("UNASSIGNED");
                
                // Set today's date
                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(today);
                allocatedEmployeeEntry.setEntryDate(date);
                
                 // Set job Id of assignment
                Jobs jobAssigned = allJobs.get(assignmentIndex);
                allocatedEmployeeEntry.setJobId(jobAssigned.getJobId());
                
                // Set job name of assignment
                allocatedEmployeeEntry.setJobName(allocatedEmployeeEntry.getJobName());
                
                // Save Entry to DB
                allocationRepository.save(allocatedEmployeeEntry);
            }           
        }
        
        return allocationRepository.findAll();
    }
    
    private HashMap<Integer, Employee> getAllEmployees(){
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        Iterable<Employee> employees = employeeService.getAllEmployee();
        
        for(Employee employee : employees){
            employeeMap.put(employee.getEmployeeId(), employee);
        }
        
        return employeeMap;
    }
        
    private ArrayList<Employee> getEmployeesPresent(HashMap<Integer, Employee> employeeList){
        // Get Today's Date
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(today);
        // Get All Absences for today
        Iterable<Attendance> todaysAbsences = attendanceService.getTodaysAttendance(date);
        // Iterate through employees, removing ones with entries in the attendance table
        for(Attendance record: todaysAbsences){
            employeeList.remove(record.getEmployee_id());
        }
        
        Collection<Employee> values = employeeList.values();
        ArrayList<Employee> listOfPresentEmployees = new ArrayList<>(values);
        
        return listOfPresentEmployees;      
    }
    
    private ArrayList<Jobs> getAllJobs(){
        ArrayList<Jobs> jobsList = new ArrayList<>();
        Iterable<Jobs> jobs = jobsService.getAllJobs();
        for(Jobs job : jobs){
            jobsList.add(job);
        }
        return jobsList;
    }
    
    private ArrayList<Ranking> getAllRankings(){
        ArrayList<Ranking> rankList = new ArrayList<>();
        Iterable<Ranking> ranks = rankingService.getAllRankings();
        for(Ranking rank : ranks){
            rankList.add(rank);
        }
        
        // Sort the list by importance in case it is not already
        rankList.sort(Comparator.comparing(Ranking::getImportance));
        
        return rankList;
    }
    
    private ArrayList<Employee> orderEmployeesBySeniority(ArrayList<Employee> employeeList){
        // Order all employees by seniority date
        employeeList.sort(Comparator.comparing(Employee::getSeniority_date));   
        
        return employeeList;
    }
    
    private ArrayList<EmployeeMatrix> getAllEmployeeMatrices(){
        ArrayList<EmployeeMatrix> matrixList = new ArrayList<>();
        Iterable<EmployeeMatrix> matrices = employeeMatrixService.getAllEmployeeMatrix();
        for(EmployeeMatrix matrix : matrices){
            matrixList.add(matrix);
        }
        
        return matrixList;
    }
    
    private int[][] createEdmondsMatrix(ArrayList<Employee> employeeList, 
            ArrayList<EmployeeMatrix> interestList, ArrayList<Jobs> jobList, 
            ArrayList<Ranking> rankingList){
        // Create empty starting matrix of size [# of employees][# of jobs]
        int[][] edmondsMatrix = new int[employeeList.size()][jobList.size()];
        
        // Get Employee Interests from EmployeeMatrices and Employees
        HashMap<Employee, List<EmployeeMatrix>> employeeInterests = 
                assembleEmployeeMatrices(employeeList, interestList);
        
        // Create the edmonds matrix based on employee interests
        for(int employeeIndex = 0; employeeIndex < employeeList.size(); employeeIndex++){
            for(int jobIndex = 0; jobIndex < jobList.size(); jobIndex++){
                // If an employee has an entry in HashMap, get jobs they are interested in
                if(employeeInterests.containsKey(employeeList.get(employeeIndex))){
                    List<EmployeeMatrix> jobsInterest = 
                            employeeInterests.get(employeeList.get(employeeIndex));
                    
                    boolean isMatched = false;
                    // Check each interest to see if it equals the current job index
                    for(EmployeeMatrix interest : jobsInterest){
                        // If there is a match, get their importance and set in edmonds matrix
                        if(interest.getJob_id().equals(jobList.get(jobIndex).getJobId())){
                            isMatched = true;
                            int importance = getImportance(
                                    employeeList.get(employeeIndex).getJob_type_id(),
                                    interest.getJob_knowledge(), rankingList);
                            edmondsMatrix[employeeIndex][jobIndex] = importance;
                        }
                    }
                    
                    // If there is no match, set to 0
                    if(!isMatched){
                        edmondsMatrix[employeeIndex][jobIndex] = 0;
                    }
                    
                    jobList.get(jobIndex);
                }
                // If no interested entries exist for this employee, add 0 for their row
                else{
                    edmondsMatrix[employeeIndex][jobIndex] = 0;
                }
            }
        } 
        return edmondsMatrix;
    }
    
    private HashMap<Employee, List<EmployeeMatrix>> assembleEmployeeMatrices(
            ArrayList<Employee> allEmployees, ArrayList<EmployeeMatrix> allMatrices){
        // Create a new HashMap Where each Employee is Mapped to their interests
        HashMap<Employee, List<EmployeeMatrix>> employeeInterests = new HashMap<>();
        
        // For every employee, check if entry matches their ID and add to list
        for(Employee employee : allEmployees){
            for(EmployeeMatrix jobInterest : allMatrices){
                // If the employee ID matches the matrix employee ID then add to HashMap
                if(jobInterest.getEmployee_id().equals(employee.getEmployeeId())){
                    // If an employee is already mapped, add to its list
                    if(employeeInterests.containsKey(employee)){
                        List<EmployeeMatrix> tempEmployeeInterestList = 
                                employeeInterests.get(employee);
                        if(tempEmployeeInterestList != null){
                            tempEmployeeInterestList.add(jobInterest);
                            employeeInterests.put(employee, tempEmployeeInterestList);
                        }                     
                    }
                    // If employee is not already mapped then create new entry in HashMap
                    else{
                        List<EmployeeMatrix> tempEmployeeInterestList = new ArrayList<>();
                        tempEmployeeInterestList.add(jobInterest);
                        employeeInterests.put(employee, tempEmployeeInterestList);
                    }
                }    
            }
        }     
        return employeeInterests;
    }
    
    private int getImportance(Integer jobTypeId, Integer knowledgeTypeId,
            ArrayList<Ranking> rankingList){
        int importance = -1;
        
        for(Ranking rank : rankingList){
            if(rank.getJobType().getId().equals(jobTypeId) && 
                    rank.getKnowLvl().equals(knowledgeTypeId)){
                importance = rank.getImportance();
                break;
            }
        }
        
        return importance;
    }
    
    private boolean bpm(int bpGraph[][], int u, boolean seen[], int matchR[], int numberOfJobsToFill) 
    {
        // Try every job one by one 
        for (int v = 0; v < numberOfJobsToFill; v++) 
        {
            // If applicant u is interested 
            // in job v and v is not visited 
            if (bpGraph[u][v] > 0 && !seen[v]) 
            {

                // Mark v as visited 
                seen[v] = true;

                // If job 'v' is not assigned to an employee
                // OR previously assigned applicant for job v (which 
                // is matchR[v]) has lower preference and 
                // an alternate job available. 
                // Since v is marked as visited in the 
                // above line, matchR[v] in the following 
                // recursive call will not get job 'v' again 
                if (matchR[v] < 0 ||( (bpGraph[u][v] >= bpGraph[matchR[v]][v]) && 
                        bpm(bpGraph, matchR[v], seen, matchR,numberOfJobsToFill))) 
                {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number 
    // of matching from M to N 
    private int[] maxBPM(int bpGraph[][], int N, int M) 
    {
        // An array to keep track of the 
        // applicants assigned to jobs. 
        // The value of matchR[i] is the 
        // applicant number assigned to job i, 
        // the value -1 indicates nobody is assigned. 
        int matchR[] = new int[N];

        // Initially all jobs are available 
        for (int i = 0; i < N; ++i)
        {
            matchR[i] = -1;
        }

        // Count of jobs assigned to applicants 
        int result = 0;
        for (int u = 0; u < M; u++) 
        {
            // Mark all jobs as not seen 
            // for next applicant. 
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; ++i) {
                seen[i] = false;
            }

            // Find if the applicant 'u' can get a job 
            if (bpm(bpGraph, u, seen, matchR, N)) {
                result++;
            }
        }

        return matchR;
    }

	
}
