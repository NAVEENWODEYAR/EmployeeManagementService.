package com.employeeservice.service;

import com.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:5454",value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/department/getByDeptCode/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);

    @GetMapping("/api/department/test")
    String test();
}
