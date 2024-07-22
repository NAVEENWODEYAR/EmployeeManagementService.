package com.departmentservice.service;

import com.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto findByDepartmentCode(String departmentCode);
}
