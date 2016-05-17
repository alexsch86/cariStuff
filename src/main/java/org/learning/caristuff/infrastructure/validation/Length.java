package org.learning.caristuff.infrastructure.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { LengthValidatorForString.class, LengthValidatorForInteger.class,
        LengthValidatorForAmount.class, LengthValidatorForLong.class })
@Inherited
public @interface Length {
    public static final String VALIDATION_TOO_LONG = "VALIDATION.TOO_LONG";

    String message() default VALIDATION_TOO_LONG;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value() default 255;

    int fractionalDigits() default 0;
}