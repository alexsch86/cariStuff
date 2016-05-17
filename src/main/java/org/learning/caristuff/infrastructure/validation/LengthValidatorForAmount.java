package org.learning.caristuff.infrastructure.validation;

import org.learning.caristuff.infrastructure.common.Amount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidatorForAmount implements ConstraintValidator<Length, Amount> {

    private int numberOfIntegerDigits;
    private int numberOfFractionalDigits;

    @Override
    public void initialize(Length constraintAnnotation) {
        numberOfIntegerDigits = constraintAnnotation.value();
        numberOfFractionalDigits = constraintAnnotation.fractionalDigits();
    }

    @Override
    public boolean isValid(Amount amount, ConstraintValidatorContext context) {
        if (amount == null || amount.getValue() == null) {
            return true;
        }
        String amountStringWithoutTrailingZeroes = amount.getValue().toPlainString();
        int integerPlaces = amountStringWithoutTrailingZeroes.indexOf('.');
        int decimalPlaces = amountStringWithoutTrailingZeroes.length() - integerPlaces - 1;
        return integerPlaces <= numberOfIntegerDigits && decimalPlaces <= numberOfFractionalDigits;
    }
}