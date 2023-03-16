package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findEmployeeByNameContaining(String name, Pageable pageable);
}
