package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen K Wodeyar
 * @date16-Jul-2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMP_DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dId;
	
	private String deptName;
	
	private String deptDescription;
	
	private String deptCode;
	
}
