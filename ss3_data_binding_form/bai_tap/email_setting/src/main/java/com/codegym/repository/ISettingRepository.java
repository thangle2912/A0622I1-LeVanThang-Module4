package com.codegym.repository;

import com.codegym.model.Setting;

import java.util.List;

public interface ISettingRepository {
    Setting setting();
    void update(Setting setting);
}
