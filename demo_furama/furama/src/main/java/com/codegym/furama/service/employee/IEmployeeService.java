package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void delete(Employee employee);
    void update(Employee employee);
    Employee findById(int i);
    Page<Employee> searchByName(String name, Pageable pageable);

}
