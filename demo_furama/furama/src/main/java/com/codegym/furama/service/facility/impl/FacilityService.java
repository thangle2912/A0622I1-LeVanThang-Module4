package com.codegym.furama.service.facility.impl;

import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.repository.facility.IFacilityRepository;
import com.codegym.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
   @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(Facility facility) {
        facilityRepository.delete(facility);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Facility> searchByName(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Page<Facility> searchByNameAndFacilityType(String name, int idFacilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityTypeId(name, idFacilityType, pageable);
    }
}
