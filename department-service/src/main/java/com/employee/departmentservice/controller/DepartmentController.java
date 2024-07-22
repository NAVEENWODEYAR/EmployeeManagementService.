package com.employee.departmentservice.controller;

import com.employee.departmentservice.dto.DepartmentDto;
import com.employee.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint(){
        log.warn("Test endpoint accessed");
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Department", "microService-1")
                .body("Welcome to the Department\nService");
    }

    @PostMapping
    public ResponseEntity<Object> addDepartment(@RequestBody DepartmentDto request){
        return new ResponseEntity(departmentService.saveDepartment(request),HttpStatus.CREATED);
    }
}
