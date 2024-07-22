package com.employeeservice.serviceImpl;

import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        var employee = modelMapper.map(employeeDto, Employee.class);
        var savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getById(Long employeeID) {
        log.info("getBy employeeID");
        var employee = employeeRepository.findById(employeeID).get();
        return modelMapper.map(employee,EmployeeDto.class);

    }
}
