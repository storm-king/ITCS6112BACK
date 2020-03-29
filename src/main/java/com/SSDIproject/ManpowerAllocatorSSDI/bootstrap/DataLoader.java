/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SSDIproject.ManpowerAllocatorSSDI.bootstrap;

import com.SSDIproject.ManpowerAllocatorSSDI.model.Student;
import com.SSDIproject.ManpowerAllocatorSSDI.repository.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository repository;

    public DataLoader(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Student student_a = new Student();
        student_a.setFirstName("Jane");
        student_a.setLastName("Doe");
        student_a.setYear("Junior");
        repository.save(student_a);

        Student student_b = new Student();
        student_b.setFirstName("Martin");
        student_b.setLastName("Fowler");
        student_b.setYear("Senior");
        repository.save(student_b);

        Student student_c = new Student();
        student_c.setFirstName("Roy");
        student_c.setLastName("Fielding");
        student_c.setYear("Freshman");
        repository.save(student_c);
    }
}
