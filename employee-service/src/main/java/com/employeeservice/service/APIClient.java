package com.employeeservice.service;

import com.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:7070",value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/department/{deploymentCode}")
    DepartmentDto getDepartment(@PathVariable("deploymentCode") String deploymentCode);

}
