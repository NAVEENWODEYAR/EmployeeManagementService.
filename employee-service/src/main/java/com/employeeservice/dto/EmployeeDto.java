package com.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeMail;
    private String departmentCode;

}
