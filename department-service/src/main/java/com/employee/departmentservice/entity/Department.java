package com.employee.departmentservice.entity;

import com.employee.departmentservice.dto.DepartmentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMP_DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public Department(DepartmentDto departmentDto){
        this.departmentId = departmentDto.getDepartmentId();
        this.departmentName = departmentDto.getDepartmentName();
        this.departmentCode = departmentDto.getDepartmentCode();
        this.departmentDescription = departmentDto.getDepartmentDescription();
    }
}
