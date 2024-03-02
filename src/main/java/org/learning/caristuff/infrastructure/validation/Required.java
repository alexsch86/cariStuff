package org.learning.caristuff.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@NotNull
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface Required {
    public static final String VALIDATION_REQUIRED_FIELD = "VALIDATION.REQUIRED_FIELD";

    String message() default VALIDATION_REQUIRED_FIELD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
