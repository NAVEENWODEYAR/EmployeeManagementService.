package com.employeeservice.service;

import com.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getById(Long employeeID);
}
