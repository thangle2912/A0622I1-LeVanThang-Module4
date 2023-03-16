package com.codegym.furama.service.facility;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();
    void save(Facility facility);
    void delete(Facility facility);
    void update(Facility facility);
    Facility findById(int id);
    Page<Facility> searchByName(String name, Pageable pageable);
    Page<Facility> searchByNameAndFacilityType(String name,int idFacilityType, Pageable pageable);

}
