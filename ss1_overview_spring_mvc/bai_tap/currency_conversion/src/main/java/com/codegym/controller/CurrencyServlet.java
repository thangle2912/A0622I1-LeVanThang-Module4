package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyServlet {

    @GetMapping("/convert")
    public String showFormConvert(){
        return "convert";
    }
    @PostMapping("/convert")
    public String convertCurrency(@RequestParam float usd, Model model){
        float convertCurrency= usd * 23000;
        model.addAttribute("convertCurrency",convertCurrency);
        return "convert";
    }
}
