package com.codegym.furama.repository.facility;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    Page<Facility> findByNameContaining(String name, Pageable pageable);
    Page<Facility> findByNameContainingAndFacilityTypeId(String name, int idFacilityType,Pageable pageable);
}
