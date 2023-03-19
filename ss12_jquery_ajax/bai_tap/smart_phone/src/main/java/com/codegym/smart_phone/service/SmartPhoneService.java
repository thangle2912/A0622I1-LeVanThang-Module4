package com.codegym.smart_phone.service;

import com.codegym.smart_phone.model.SmartPhone;
import com.codegym.smart_phone.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService{

    @Autowired
    ISmartPhoneRepository smartPhoneRepository;
    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public void save(SmartPhone smartphone) {
        smartPhoneRepository.save(smartphone);
    }

    @Override
    public void update(SmartPhone smartphone) {
        smartPhoneRepository.save(smartphone);
    }

    @Override
    public SmartPhone findById(int id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        smartPhoneRepository.deleteById(id);
    }
}
