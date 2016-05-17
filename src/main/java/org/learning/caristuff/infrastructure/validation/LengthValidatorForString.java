package org.learning.caristuff.infrastructure.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidatorForString implements ConstraintValidator<Length, String> {

    private int maxLength;

    @Override
    public void initialize(Length constraintAnnotation) {
        maxLength = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        if (string == null) {
            return true;
        }
        return string.length() <= maxLength;
    }
}
