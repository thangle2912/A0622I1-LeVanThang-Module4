package com.codegym.smart_phone.controller;

import com.codegym.smart_phone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("smartphone")
public class SmartPhoneController {
    @Autowired
    ISmartPhoneService smartPhoneService;

    @GetMapping("/list")
    public String showList(){
        return "list";
    }

}
