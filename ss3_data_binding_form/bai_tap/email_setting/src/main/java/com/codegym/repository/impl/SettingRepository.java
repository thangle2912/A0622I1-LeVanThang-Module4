package com.codegym.repository.impl;

import com.codegym.model.Setting;
import com.codegym.repository.ISettingRepository;
import org.springframework.stereotype.Repository;


@Repository
public class SettingRepository implements ISettingRepository {

    static Setting setting;
    static {
        setting=new Setting( "English", 5, true, "ThangLe");
    }

    @Override
    public Setting setting() {
        return setting;
    }

    @Override
    public void update(Setting setting) {
        this.setting.setLanguage(setting.getLanguage());
        this.setting.setPageSize(setting.getPageSize());
        this.setting.setSpamFilter(setting.isSpamFilter());
        this.setting.setSignature(setting.getSignature());
    }
}
