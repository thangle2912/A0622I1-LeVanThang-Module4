package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.employee.IEmployeeRepository;
import com.codegym.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int i) {
        return employeeRepository.findById(i).orElse(null);
    }

    @Override
    public Page<Employee> searchByName(String name, Pageable pageable) {
        return employeeRepository.findEmployeeByNameContaining(name,pageable);
    }
}
