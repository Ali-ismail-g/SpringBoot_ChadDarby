package com.springbootTutorial.demo.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component //mark the class as spring bean
//@Lazy
//@Primary   //the primary implementation to be used in case there's multiple implementation

public class BaseBallCoach implements Coach{
    public BaseBallCoach(){
        System.out.println("in Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getTrainingDetails(){
        return "Practice Baseball twice a week for 3 hrs each time!!";
    }
}
