package com.employeeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "DEPARTMENT-SERVICE",
				version = "1.0",
				description = "Microservice-1 for Employee Management System, handling department-related operations.",
				termsOfService = "http://termsOfService.url",
				contact = @Contact(
						name = "Support Team",
						email = "support@example.com",
						url = "http://support.url"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = {
				@Server(
						url = "http://localhost:7070",
						description = "Development server",
						variables = {
								@ServerVariable(
										name = "port",
										description = "Port number",
										defaultValue = "7070"
								)
						}
				)
		}
)
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("EMPLOYEE\nSERVICE");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public WebClient webClient(){
		return WebClient.builder().build();
	}

}
