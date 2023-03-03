package com.codegym.furama_management.repository.employee;

import com.codegym.furama_management.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Division,Integer> {
}
