package com.departmentservice.serviceImpl;

import com.departmentservice.entity.Department;
import com.departmentservice.repository.DepartmentRepository;
import com.departmentservice.dto.DepartmentDto;
import com.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        var save = departmentRepository.save(department);
        log.info("Department added successfully",department.getDepartmentName());
        return new DepartmentDto(save);
    }

    @Override
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        log.error("DepartmentDto findByDepartmentCode");
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(department);
        return departmentDto;
    }

    @Override
    public Object getDepartmentList() {
        return departmentRepository.findAll();
    }
}
