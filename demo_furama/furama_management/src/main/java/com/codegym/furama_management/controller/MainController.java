package com.codegym.furama_management.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/main")
    public String showMain(){
        return "index";
    }
}
