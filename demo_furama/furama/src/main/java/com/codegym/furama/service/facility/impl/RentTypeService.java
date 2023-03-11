package com.codegym.furama.service.facility.impl;

import com.codegym.furama.model.facility.RentType;
import com.codegym.furama.repository.facility.IRentTypeRepository;
import com.codegym.furama.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(RentType rentType) {
        rentTypeRepository.delete(rentType);
    }

    @Override
    public void update(RentType rentType) {
        rentTypeRepository.save(rentType);
    }
}
