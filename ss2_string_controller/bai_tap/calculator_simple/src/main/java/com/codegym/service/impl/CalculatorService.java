package com.codegym.service.impl;

import com.codegym.repository.ICalculatorRepository;
import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Autowired
    ICalculatorRepository calculatorRepository;
    @Override
    public float calculator(float number1, float number2, char operator) {
        return calculatorRepository.calculator(number1,number2,operator);
    }
}
