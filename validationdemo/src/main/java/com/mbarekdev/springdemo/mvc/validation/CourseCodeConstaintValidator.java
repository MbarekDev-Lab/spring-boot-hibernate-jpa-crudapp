package com.mbarekdev.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstaintValidator implements ConstraintValidator<CourseCode , String> {
    private String coursePrefix;
    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (theCode != null){
            result = theCode.startsWith(coursePrefix);
        }else {
            result = true;
        }
       // if (theCode == null) return true;
      //  boolean result = theCode.startsWith(coursePrefix);
        return result;
    }
}
