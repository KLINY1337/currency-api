package com.test.task.sputnik.currency.api.currency.exchange.enumeration.validator.implementation;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.validator.EnumValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Enum<?>> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        enumClass = (Class<? extends Enum<?>>) constraintAnnotation.targetClassType();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null values are considered valid
        }

        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        for (Enum<?> enumConstant : enumConstants) {
            if (enumConstant.name().equals(value.name())) {
                return true; // found a match
            }
        }

        return false; // no match found
    }
}
