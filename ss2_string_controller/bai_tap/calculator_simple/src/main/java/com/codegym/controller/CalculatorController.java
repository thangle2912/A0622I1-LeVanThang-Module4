package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam float number1, @RequestParam float number2, @RequestParam String operator, Model model) {
        char operator1 = operator.charAt(0);

        float result = calculatorService.calculator(number1, number2, operator1);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", result);
        return "calculator";
    }
}
