package com.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${developer.name}")
    private String developer_name;

    @Value("${team.name}")
    private String team_name;

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "developer name is: "+ developer_name + " ,Joined team: "+team_name;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k Daily!!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!!";
    }
}
