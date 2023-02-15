package com.codegym.controller;

import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/music")
public class SongController {
    @Autowired
    ISongService musicService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "list";
    }
//    @GetMapping("/create")
//    public String showFormCreate(Model ){
//
//    }
}
