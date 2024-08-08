package com.employeeservice.controller;

import com.employeeservice.dto.APIResponseDto;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

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

    // restTemplate,
//    @GetMapping("/{employeeID}")
//    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long employeeID){
//        log.debug("getEmployeeById",employeeID);
//        var apiResponse = employeeService.getById(employeeID);
//        return new ResponseEntity(apiResponse,HttpStatus.FOUND);
//    }
//
//    // webClient,
//    @GetMapping("/getEmp/{employeeID}")
//    public ResponseEntity<APIResponseDto> getEmpById(@PathVariable Long employeeID){
//        log.debug("getEmployeeById",employeeID);
//        var apiResponse = employeeService.getByEmpId(employeeID);
//        return new ResponseEntity(apiResponse,HttpStatus.FOUND);
//    }

     // openFeign,
    @GetMapping("/getEmployee/{employeeID}")
    public ResponseEntity<APIResponseDto> getEmployeById(@PathVariable Long employeeID){
        log.debug("getEmployeeById",employeeID);
        var apiResponse = employeeService.getByEmployeeId(employeeID);
        return new ResponseEntity(apiResponse,HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<APIResponseDto> getEmployeByIdTest(){
        log.debug("getEmployeeByIdTest");
        employeeService.test();
        return new ResponseEntity(employeeService.test(),HttpStatus.FOUND);
    }
}
