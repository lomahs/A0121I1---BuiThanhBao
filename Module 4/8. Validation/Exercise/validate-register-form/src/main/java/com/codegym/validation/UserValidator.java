package com.codegym.validation;

import com.codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getFirstName().isEmpty()){
            errors.rejectValue("firstName","name.empty");
        }

        if (user.getLastName().isEmpty()){
            errors.rejectValue("lastName","name.empty");
        }

        if (user.getFirstName().length() < 5 || user.getFirstName().length() >45 ){
            errors.rejectValue("firstName","name.length.outRange");
        }

        if (user.getLastName().length() < 5 || user.getLastName().length() >45 ){
            errors.rejectValue("lastName","name.length.outRange");
        }

        if (user.getPhoneNumber().length() != 10){
            errors.rejectValue("phoneNumber","phoneNumber.length");
        }

        if (!user.getPhoneNumber().startsWith("0")){
            errors.rejectValue("phoneNumber","phoneNumber.startNumber");
        }

        if (user.getAge() < 18){
            errors.rejectValue("age","age.range");
        }

        if (!user.getEmail().matches("\\w+@(\\w+\\.)+(\\w+)")){
            errors.rejectValue("email","email.regex");
        }
    }
}