package com.SSDIproject.ManpowerAllocatorSSDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.SSDIproject.ManpowerAllocatorSSDI.*"})
@EntityScan("com.SSDIproject.ManpowerAllocatorSSDI.*")
@EnableJpaRepositories ("com.SSDIproject.ManpowerAllocatorSSDI.*") 
public class ManpowerAllocatorSsdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManpowerAllocatorSsdiApplication.class, args);
	}

}
