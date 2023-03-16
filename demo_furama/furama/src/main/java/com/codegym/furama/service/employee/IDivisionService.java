package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
    void save(Division division);
    void delete(Division division);
    void update(Division division);
}
