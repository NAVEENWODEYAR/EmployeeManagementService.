package com.employeeservice.service.serviceImpl;

import com.employeeservice.dto.APIResponseDto;
import com.employeeservice.dto.DepartmentDto;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.APIClient;
import com.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
//@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

//    private final RestTemplate restTemplate;

//    private final WebClient webClient;

    private final APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        var employee = modelMapper.map(employeeDto, Employee.class);
        var savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

//    @Override
//    public APIResponseDto getById(Long employeeID) {
//        log.info("getBy employeeID");
//        var employee = employeeRepository.findById(employeeID).get();
//
//        var responseEntity = restTemplate.getForEntity("http://localhost:7070/api/department/" + employee.getDepartmentCode(), DepartmentDto.class);
//
//        var departmentDto = responseEntity.getBody();
//
//        var employeeDto = modelMapper.map(employee, EmployeeDto.class);
//
//        APIResponseDto apiResponseDto = new APIResponseDto();
//                        apiResponseDto.setEmployee(employeeDto);
//                        apiResponseDto.setDepartment(departmentDto);
//        return apiResponseDto;
//    }
//
//    @Override
//    public APIResponseDto getByEmpId(Long employeeID) {
//        log.warn("Communication using WebClient,");
//        var employee = employeeRepository.findById(employeeID).get();
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:7070/api/department/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//
//        var employeeDto = modelMapper.map(employee, EmployeeDto.class);
//
//        APIResponseDto apiResponseDto = new APIResponseDto();
//                        apiResponseDto.setEmployee(employeeDto);
//                        apiResponseDto.setDepartment(departmentDto);
//
//        return apiResponseDto;
//    }

    @Override
    public APIResponseDto getByEmployeeId(Long employeeID) {
        log.debug("Using OpenFeign Client");

        var employee = employeeRepository.findById(employeeID).get();
        var employeeDto = modelMapper.map(employee, EmployeeDto.class);
        var departmentCode = employee.getDepartmentCode();
        Class<? extends APIClient> aClass = apiClient.getClass();
        log.info(String.valueOf(aClass));

        DepartmentDto departmentDto = new DepartmentDto();
        try {
             departmentDto = apiClient.getDepartment(departmentCode);
        }catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            log.info(localizedMessage);
        }

        APIResponseDto apiResponseDto = new APIResponseDto();
                        apiResponseDto.setEmployee(employeeDto);
                        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;

    }

    @Override
    public String test() {
        int i = apiClient.hashCode();
        log.info(String.valueOf(i));
        String test=null;
        try{
             test = apiClient.test();
        }catch (Exception e){
            System.out.println(e.getCause());
        }
        log.info(test);
        log.warn(test);
        return test;
    }
}
