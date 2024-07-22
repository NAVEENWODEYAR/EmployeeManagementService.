package com.employee.departmentservice.serviceImpl;

import com.employee.departmentservice.dto.DepartmentDto;
import com.employee.departmentservice.entity.Department;
import com.employee.departmentservice.repository.DepartmentRepository;
import com.employee.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        var save = departmentRepository.save(department);

        return new DepartmentDto(save);
    }
}
