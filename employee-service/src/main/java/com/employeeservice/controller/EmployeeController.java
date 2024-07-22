package com.employeeservice.controller;

import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        log.error("Test endpoint accessed");
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Employee", "microService-2")
                .body("Welcome to Employee\nService");
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto request){
        log.info("Saving employee",request.getEmployeeFirstName());
        return new ResponseEntity(employeeService.saveEmployee(request),HttpStatus.CREATED);
    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeID){
        log.debug("getEmployeeById",employeeID);
        return new ResponseEntity(employeeService.getById(employeeID),HttpStatus.FOUND);
    }
}
