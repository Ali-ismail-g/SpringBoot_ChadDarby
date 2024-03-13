package com.springbootTutorial.demo.springCoreDemo.rest;

import com.springbootTutorial.demo.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
   // private Coach secondCoach;

    @Autowired //autowired tells spring to inject dependency by using construction injection
    DemoController(@Qualifier("problemSolvingCoach") Coach theCoach
    //               ,@Qualifier("problemSolvingCoach") Coach anotherCoach
    ){ //add @Qualifier in case there is multiple class implementing interface so mention bean id with first letter lower case
        System.out.println("in Constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
        //secondCoach = anotherCoach;
    }
    //Qualifier has higher priority than Primary !!
//    @Autowired //autowired tells spring to inject dependency by using setter injection
//    public void setMyCoach(Coach theCoach){  //we used Primary in case there's multiple implementation in only one primary needed class
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyWorkout")
    public String getTrainingDetails(){
        return myCoach.getTrainingDetails();
    }
//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: theCoach == anotherCoach: "+ (myCoach == secondCoach); //true for singleton, false for prototype
//
//    }
}
