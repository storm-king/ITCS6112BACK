 
package com.SSDIproject.ManpowerAllocatorSSDI.Services;

import com.SSDIproject.ManpowerAllocatorSSDI.model.WorkGroups;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.WorkGroupsRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkGroupsService {
	
	@Autowired
	private WorkGroupsRepository workGroupsRepository;
        
        
	
	// Add new Job Type
	public boolean addWorkGroup(WorkGroups wg) {
		
		try {
			workGroupsRepository.save(wg);
			return true;
		} catch(Exception e) {
			return false;
		}
	}


        // Update a Job Type
	public boolean updateWorkGroup(Integer id, WorkGroups wg) {
		try {
			wg.setId(id);
			workGroupsRepository.save(wg);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	// Get all Job Types
	public Iterable<WorkGroups> getAllWorkGroups(){
		return workGroupsRepository.findAll();
	}

	
	// Get single Job Type by Id
	public Optional<WorkGroups> getWorkGroup(Integer id) {
		return workGroupsRepository.findById(id);
	}

	
	// Delete a Job Type
	public boolean deleteWorkGroup(Integer id) {
		try{
			workGroupsRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
