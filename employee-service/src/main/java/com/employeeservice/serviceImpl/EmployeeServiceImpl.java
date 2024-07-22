package com.employeeservice.serviceImpl;

import com.employeeservice.dto.APIResponseDto;
import com.employeeservice.dto.DepartmentDto;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        var employee = modelMapper.map(employeeDto, Employee.class);
        var savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getById(Long employeeID) {
        log.info("getBy employeeID");
        var employee = employeeRepository.findById(employeeID).get();

        var responseEntity = restTemplate.getForEntity("http://localhost:7070/api/department/" + employee.getDepartmentCode(), DepartmentDto.class);

        var departmentDto = responseEntity.getBody();

        var employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
                        apiResponseDto.setEmployee(employeeDto);
                        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
