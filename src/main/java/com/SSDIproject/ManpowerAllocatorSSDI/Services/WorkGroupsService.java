 
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Jobs;
import com.SSDIproject.ManpowerAllocatorSSDI.model.WorkGroups;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.WorkGroupsRepository;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkGroupsService {
	
	@Autowired
	private WorkGroupsRepository workGroupsRepository;
        
        
	
	// Add new Work Group
	public boolean addWorkGroup(WorkGroups wg) {
		
		try {
			workGroupsRepository.save(wg);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Work Group
	public boolean updateWorkGroup(Integer id, WorkGroups wg) {
		try {
			wg.setId(id);
                        Optional<WorkGroups> previous = workGroupsRepository.findById(id);
                        WorkGroups previousWorkGroup = previous.get();
                        wg.setId(id);
                        wg.setJobs(previousWorkGroup.getJobs());
			workGroupsRepository.save(wg);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
        
        // Update a Work Group
	public boolean updateWorkGroupJobs(Integer id, WorkGroups wg) {
		try {
                        Iterable<WorkGroups> allWorkGroups = workGroupsRepository.findAll();
                        for(WorkGroups workGroup : allWorkGroups){
                            if(workGroup.getWorkGroupName().equals(wg.getWorkGroupName())){
                                wg.setId(workGroup.getId());
                                workGroupsRepository.delete(workGroup);
                                workGroupsRepository.save(wg);
                                return true;
                            }
                        }
                        return false;	
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Work Groups
	public Iterable<WorkGroups> getAllWorkGroups(){
		return workGroupsRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<WorkGroups> getWorkGroup(Integer id) {
		return workGroupsRepository.findById(id);
	}

	
	// Delete a Work Group
	public boolean deleteWorkGroup(Integer id) {
		try{
			workGroupsRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
