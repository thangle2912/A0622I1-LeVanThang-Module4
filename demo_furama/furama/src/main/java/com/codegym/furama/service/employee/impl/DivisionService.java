package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.repository.employee.IDivisionRepository;
import com.codegym.furama.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(Division division) {
        divisionRepository.delete(division);
    }

    @Override
    public void update(Division division) {
        divisionRepository.save(division);
    }
}
