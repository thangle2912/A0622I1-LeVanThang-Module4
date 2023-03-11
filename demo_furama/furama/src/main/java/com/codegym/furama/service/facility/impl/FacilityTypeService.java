package com.codegym.furama.service.facility.impl;

import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.repository.facility.IFacilityTypeRepository;
import com.codegym.furama.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void delete(FacilityType facilityType) {
        facilityTypeRepository.delete(facilityType);
    }

    @Override
    public void update(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }
}
