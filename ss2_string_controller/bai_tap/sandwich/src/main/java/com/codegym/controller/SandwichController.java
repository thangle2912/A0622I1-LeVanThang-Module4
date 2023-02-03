package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.ModalExclude;

@Controller
public class SandwichController {



    @GetMapping("/sandwich")
    public String showForm(){
        return "sandwich";
    }
    @PostMapping("/sandwich")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiments",condiment);
        return "sandwich";
    }
}
