package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.validation.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("/register")
    public String showFormRegister(Model model){
        model.addAttribute("user",new User());

        return "index";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model){
        new UserValidator().validate(user,bindingResult);
        model.addAttribute("user", user);
        if (bindingResult.hasFieldErrors()){

            return "index";
        }

        return "successful";
    }


}