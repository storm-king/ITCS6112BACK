/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.bootstrap;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobTypesRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final JobTypesRepository jtRepository;

    public DataLoader(JobTypesRepository jtRepository) {
        this.jtRepository = jtRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {    
//   EXAMPLE OF HOW TO LOAD DEFAULT DATA TO DATABASE ON APP START:
//        JobTypes jobType_a = new JobTypes();
//        jobType_a.setTypeName("Test Type 1");
//        jtRepository.save(jobType_a);
    }
}
