package org.learning.caristuff.infrastructure.common;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Set;

import static com.google.common.collect.Collections2.transform;
import static org.apache.commons.lang.StringUtils.join;

@Service
public class EntityValidator implements Validator {

    private javax.validation.Validator targetValidator;

    public EntityValidator() {
        this.targetValidator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return targetValidator != null;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = targetValidator.validate(target);

        if( !constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(join(
                    transform(constraintViolations, ConstraintViolation<Object>::getMessage), ", "),
                    constraintViolations);
        }
    }

}
