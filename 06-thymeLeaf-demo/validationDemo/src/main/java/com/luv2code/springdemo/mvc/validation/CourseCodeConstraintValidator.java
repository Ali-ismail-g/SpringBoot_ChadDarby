package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) { //theCode is the string entered by user from HTML and constraintValidatorContext which we can use to give additional error msg
        boolean result ;
        if(theCode != null){
            result= theCode.startsWith(coursePrefix);
        }else {
            return true;
        }
        return result;
    }
}
