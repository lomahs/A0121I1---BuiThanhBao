package vn.codegym.furamaresort.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CurrentDateValidator implements ConstraintValidator<DateBeforeCurrent, LocalDate> {


    @Override
    public void initialize(DateBeforeCurrent constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate != null)
            return localDate.isBefore(LocalDate.now());
        else return false;
    }

}