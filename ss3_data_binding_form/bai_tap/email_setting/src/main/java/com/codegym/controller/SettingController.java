package com.codegym.controller;

import com.codegym.model.Setting;
import com.codegym.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {

    @Autowired
    ISettingService settingService;

    @GetMapping("/setting")
    public String showSetting(Model model){
        model.addAttribute("setting", settingService.setting());
        return "setting";
    }

    @ModelAttribute("languages")
    public String[] arrayLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] arrayPageSize() {
        return new int[]{5,10,15,25,50,100};
    }

    @GetMapping("/update")
    public String showFormSetting(Model model) {
//        model.addAttribute("setting", new Setting());
        model.addAttribute("setting", settingService.setting());

        return "update";
    }

    @PostMapping("/update")
    public String save(@ModelAttribute Setting setting, Model model, RedirectAttributes redirectAttributes){
        settingService.update(setting);
        redirectAttributes.addFlashAttribute("mess", "Success");
        return "redirect:setting";
    }


}
