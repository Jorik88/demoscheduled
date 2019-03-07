package com.example.alex.demoscheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoscheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoscheduledApplication.class, args);
	}

}
