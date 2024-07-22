package com.employee.departmentservice.dto;

import com.employee.departmentservice.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public DepartmentDto(Department department){
        this.departmentId =department.getDepartmentId();
        this.departmentName =department.getDepartmentName();
        this.departmentDescription =department.getDepartmentDescription();
        this.departmentCode = department.getDepartmentCode();
    }
}
