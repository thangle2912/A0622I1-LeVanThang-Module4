package com.codegym.furama.service.facility;

import com.codegym.furama.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
    void save(RentType rentType);
    void delete(RentType rentType);
    void update(RentType rentType);
}
