package com.employee.departmentservice.service;

import com.employee.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
}
