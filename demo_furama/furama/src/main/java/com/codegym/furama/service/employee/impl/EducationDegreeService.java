package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.repository.employee.IEducationDegreeRepository;
import com.codegym.furama.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void delete(EducationDegree educationDegree) {
        educationDegreeRepository.delete(educationDegree);
    }

    @Override
    public void update(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }
}
