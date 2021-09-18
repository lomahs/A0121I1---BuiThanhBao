package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String show(){
        return "calculator";
    }

    @GetMapping("/calculator")
    public String calculate(double firstOperand, double secondOperand, String operator, Model model){
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        switch (operator){
            case "add":
                model.addAttribute("result",firstOperand + secondOperand);
                break;
            case "sub":
                model.addAttribute("result",firstOperand - secondOperand);
                break;
            case "multi":
                model.addAttribute("result",firstOperand * secondOperand);
                break;
            case "div":
                if (secondOperand != 0) {
                    model.addAttribute("result", firstOperand / secondOperand);
                }else {
                    model.addAttribute("error","Cannot divide by 0");
                }
                break;
        }

        return "calculator";
    }
}
