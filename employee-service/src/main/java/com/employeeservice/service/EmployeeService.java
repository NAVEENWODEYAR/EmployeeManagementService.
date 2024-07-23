package com.employeeservice.service;

import com.employeeservice.dto.APIResponseDto;
import com.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getById(Long employeeID);

    APIResponseDto getByEmpId(Long employeeID);

    APIResponseDto getByEmployeeId(Long employeeID);
}
