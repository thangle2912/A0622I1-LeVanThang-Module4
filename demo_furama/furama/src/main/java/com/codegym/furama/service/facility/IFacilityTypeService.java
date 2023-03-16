package com.codegym.furama.service.facility;

import com.codegym.furama.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
    void save(FacilityType facilityType);
    void delete(FacilityType facilityType);
    void update(FacilityType facilityType);
}
