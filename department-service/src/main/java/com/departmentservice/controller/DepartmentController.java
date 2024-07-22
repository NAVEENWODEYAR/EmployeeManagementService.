package com.departmentservice.controller;

import com.departmentservice.dto.DepartmentDto;
import com.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint(){
        log.warn("Test endpoint accessed");
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Department", "microService-1")
                .body("Welcome to the Department\nService");
    }

    @PostMapping
    public ResponseEntity<Object> addDepartment(@RequestBody DepartmentDto request){
        log.info("adding new department");
        return new ResponseEntity(departmentService.saveDepartment(request),HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
        log.info("Department found", departmentCode);
        return new ResponseEntity(departmentService.findByDepartmentCode(departmentCode),HttpStatus.FOUND);
    }
}
