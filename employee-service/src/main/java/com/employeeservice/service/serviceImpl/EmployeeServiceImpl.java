package com.employeeservice.service.serviceImpl;

import com.employeeservice.dto.APIResponseDto;
import com.employeeservice.dto.DepartmentDto;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.APIClient;
import com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private final APIClient apiClient;

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

    @Override
    public APIResponseDto getByEmpId(Long employeeID) {
        log.warn("Communication using WebClient,");
        var employee = employeeRepository.findById(employeeID).get();
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:7070/api/department/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        var employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
                        apiResponseDto.setEmployee(employeeDto);
                        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public APIResponseDto getByEmployeeId(Long employeeID) {
        log.debug("Using OpenFeign Client");

        var employee = employeeRepository.findById(employeeID).get();
        var departmentCode = employee.getDepartmentCode();
        log.info(departmentCode);
        var departmentDto = apiClient.getDepartment(departmentCode);

        var employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
                        apiResponseDto.setEmployee(employeeDto);
                        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
