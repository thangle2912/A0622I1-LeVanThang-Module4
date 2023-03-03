package com.example.borrow_book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterReturning(pointcut = "execution(* com.example.borrow_book.controller.BookController.*(..))")
    public void LogMethodReturn(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Tên phương thức là: " + name);
        System.err.println("Các tham số là: " + args);
    }
}