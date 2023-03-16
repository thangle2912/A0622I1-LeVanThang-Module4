package com.codegym.furama.service.contract.impl;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.repository.contract.IAttachFacilityRepository;
import com.codegym.furama.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void delete(AttachFacility attachFacility) {
        attachFacilityRepository.delete(attachFacility);
    }

    @Override
    public void update(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }
}
