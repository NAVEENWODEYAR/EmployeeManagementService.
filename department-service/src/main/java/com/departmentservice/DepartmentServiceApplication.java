package com.departmentservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		System.out.println("DEPARTMENT\nSERVICE");
	}

}
