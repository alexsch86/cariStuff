package org.learning.caristuff.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LengthValidatorForInteger implements ConstraintValidator<Length, Integer> {

    private int maxLength;

    @Override
    public void initialize(Length constraintAnnotation) {
        maxLength = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        if (integer == null) {
            return true;
        }
        return String.valueOf(integer).length() <= maxLength;
    }
}