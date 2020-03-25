/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.bootstrap;

import com.SSDIproject.ManpowerAllocatorSSDI.model.JobTypes;
import com.SSDIproject.ManpowerAllocatorSSDI.model.Student;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.JobTypesRepository;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository sRepository;
    private final JobTypesRepository jtRepository;

    public DataLoader(StudentRepository sRepository, JobTypesRepository jtRepository) {
        this.sRepository = sRepository;
        this.jtRepository = jtRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Student student_a = new Student();
        student_a.setFirstName("Jane");
        student_a.setLastName("Doe");
        student_a.setYear("Junior");
        sRepository.save(student_a);

        Student student_b = new Student();
        student_b.setFirstName("Martin");
        student_b.setLastName("Fowler");
        student_b.setYear("Senior");
        sRepository.save(student_b);

        Student student_c = new Student();
        student_c.setFirstName("Roy");
        student_c.setLastName("Fielding");
        student_c.setYear("Freshman");
        sRepository.save(student_c);
        
        JobTypes jobType_a = new JobTypes();
        jobType_a.setTypeName("Test Type 1");
        jtRepository.save(jobType_a);
        
        JobTypes jobType_b = new JobTypes();
        jobType_a.setTypeName("Test Type 2");
        jtRepository.save(jobType_b);
        
        JobTypes jobType_c = new JobTypes();
        jobType_a.setTypeName("Test Type 3");
        jtRepository.save(jobType_c);
    }
}
