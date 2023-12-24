package com.test.task.sputnik.currency.api.currency.exchange.enumeration.validator;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.validator.implementation.EnumValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidator {

    Class<?> targetClassType();

    String message() default "Invalid value for enum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
