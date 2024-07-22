package com.employee.employeeservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        log.error("Test endpoint accessed");
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Employee", "microService-2")
                .body("Welcome to Employee\nService");
    }
}
