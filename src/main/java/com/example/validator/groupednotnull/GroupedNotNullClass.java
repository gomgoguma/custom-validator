package com.example.validator.groupednotnull;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GroupedNotNullValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GroupedNotNullClass {
    String message() default "Validation failed for group";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
