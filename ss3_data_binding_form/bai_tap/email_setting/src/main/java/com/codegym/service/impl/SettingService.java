package com.codegym.service.impl;

import com.codegym.model.Setting;
import com.codegym.repository.ISettingRepository;
import com.codegym.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
    @Autowired
    ISettingRepository settingRepository;

    @Override
    public Setting setting() {
        return settingRepository.setting();
    }

    @Override
    public void update(Setting setting) {
        settingRepository.update(setting);
    }
}
