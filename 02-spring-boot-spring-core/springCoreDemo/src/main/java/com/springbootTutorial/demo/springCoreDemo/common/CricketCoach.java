package com.springbootTutorial.demo.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //mark the class as spring bean
//@Lazy
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("in Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getTrainingDetails(){
        return "practice Cricket for 3 hrs every day for the next two years!! :~)";
    }
}
