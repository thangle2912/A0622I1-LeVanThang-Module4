package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
    void save(EducationDegree educationDegree);
    void delete(EducationDegree educationDegree);
    void update(EducationDegree educationDegree);
}
