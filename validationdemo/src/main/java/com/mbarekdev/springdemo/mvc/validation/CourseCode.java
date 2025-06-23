package com.mbarekdev.springdemo.mvc.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstaintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
// define default cours code
    public String value() default "MbarekDev";

    // define default error message
    public String message() default "must start with Dev";

    //difine default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload> [] payload() default {};

}
