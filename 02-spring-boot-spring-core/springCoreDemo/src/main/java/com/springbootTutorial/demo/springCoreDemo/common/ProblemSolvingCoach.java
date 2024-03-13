package com.springbootTutorial.demo.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //mark the class as spring bean
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Lazy //Prototype beans are lazy by default. There is no need to use the @Lazy annotation for prototype scopes beans.
public class ProblemSolvingCoach implements Coach {
    public ProblemSolvingCoach(){
        System.out.println("in Constructor: "+ getClass().getSimpleName());
    }
    @PostConstruct //used only in singleton not prototype
    public void doStuffAtStartup(){
        System.out.println("in doStuffAtStartup() custom init method: "+ getClass().getSimpleName());
    }
    @PreDestroy //used only in singleton not prototype
    public void doStuffAtCleanup(){
        System.out.println("in doStuffAtCleanup() custom destroy method: "+ getClass().getSimpleName());
    }
    @Override
    public String getTrainingDetails(){
        return "Practice Problem Solving everyday for 3 hrs each time!!";
    }
}
