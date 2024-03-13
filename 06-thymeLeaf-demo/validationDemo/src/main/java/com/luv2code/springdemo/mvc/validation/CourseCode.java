package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)  //retain the annotation in the java class file, process it at runtime
public @interface CourseCode {
    //define default Course Code
    public String value() default "LUV";
    //define default error message
    public String message() default "it must start with LUV";
    //define default groups -> it will group validation constraints together
    public Class<?>[] groups() default{};
    //define default payloads -> it will give additional information about the validation error
    public Class<? extends Payload>[] payload() default{};
}
