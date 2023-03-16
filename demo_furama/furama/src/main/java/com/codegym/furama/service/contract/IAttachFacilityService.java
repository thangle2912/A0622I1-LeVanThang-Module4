package com.codegym.furama.service.contract;

import com.codegym.furama.model.contract.AttachFacility;


import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    void save(AttachFacility attachFacility);

    void delete(AttachFacility attachFacility);

    void update(AttachFacility attachFacility);

    AttachFacility findById(int id);
}
