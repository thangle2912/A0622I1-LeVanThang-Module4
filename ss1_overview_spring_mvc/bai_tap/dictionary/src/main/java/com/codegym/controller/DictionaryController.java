package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String showForm(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam String english, Model  model){
        String result = dictionaryService.search(english);
        model.addAttribute("result",result);
        return "/dictionary";
    }

}
