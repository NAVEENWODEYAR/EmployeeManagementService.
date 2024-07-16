package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Department;

/**
 * @author Naveen K Wodeyar
 * @date16-Jul-2024
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
