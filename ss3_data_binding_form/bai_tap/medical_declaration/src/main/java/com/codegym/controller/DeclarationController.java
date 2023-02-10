package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {
    @Autowired
    IDeclarationService declarationService;
    @ModelAttribute("nationality")
    public String[] arrayNationality() {
        return new String[]{"Việt Nam", "Lào", "Thái Lan"};
    }

    @ModelAttribute("yeahOfBirth")
    public int[] arrayYeahOfBirth() {
        int[] yeahOfBirth = new int[100];
        for (int i = 0; i <100 ; i++) {
            yeahOfBirth[i]=1923+i;
        }
        return yeahOfBirth;
//        return new int[]{1,2,3,4,5,6};
    }

    @GetMapping("/declaration")
    public String showList(Model model){
        model.addAttribute("declarationList",declarationService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("declaration", new Declaration());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes){
        declarationService.save(declaration);
        redirectAttributes.addFlashAttribute("mess", "Success");
        return "redirect:declaration";
    }
}
