package org.learning.caristuff.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LengthValidatorForLong implements ConstraintValidator<Length, Long> {

    private int maxLength;

    @Override
    public void initialize(Length constraintAnnotation) {
        maxLength = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Long number, ConstraintValidatorContext context) {
        if (number == null) {
            return true;
        }
        return String.valueOf(number).length() <= maxLength;
    }
}
