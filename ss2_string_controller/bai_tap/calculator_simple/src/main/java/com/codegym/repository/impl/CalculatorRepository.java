package com.codegym.repository.impl;

import com.codegym.repository.ICalculatorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository {
    @Override
    public float calculator(float number1, float number2, char operator) {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (number2 != 0){
                    return number1/number2;
                }else {
                    throw  new RuntimeException("Số thứ 2 phải khác 0");
                }
            default:
                throw  new RuntimeException("Biểu thức lỗi !");
        }
    }
}
