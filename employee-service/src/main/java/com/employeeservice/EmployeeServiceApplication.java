package com.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("EMPLOYEE\nSERVICE");
	}

	@Bean
	public ModelMapper modelM(){
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
