package org.learning.caristuff.infrastructure.common;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public abstract class EntityValidator<ENTITY> implements Validator {

    private Class<ENTITY> clazz;

    public EntityValidator(Class<ENTITY> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == this.clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasFieldErrors()) {
        }
    }

}
