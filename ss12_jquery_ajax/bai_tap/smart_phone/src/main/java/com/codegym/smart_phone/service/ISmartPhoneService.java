package com.codegym.smart_phone.service;

import com.codegym.smart_phone.model.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();
    void save(SmartPhone smartphone);
    void update(SmartPhone smartphone);
    SmartPhone findById(int id);
    void remove(int id);
}
