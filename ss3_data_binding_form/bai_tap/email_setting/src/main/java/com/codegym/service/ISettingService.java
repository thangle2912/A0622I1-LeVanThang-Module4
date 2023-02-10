package com.codegym.service;

import com.codegym.model.Setting;

import java.util.List;

public interface ISettingService {
    Setting setting();
    void update(Setting setting);
}
