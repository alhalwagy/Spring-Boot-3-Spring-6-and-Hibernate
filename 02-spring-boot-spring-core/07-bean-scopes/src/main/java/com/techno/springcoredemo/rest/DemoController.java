package com.techno.springcoredemo.rest;

import com.techno.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private  Coach anotherCoach;

@Autowired
public  DemoController(@Qualifier("baseballCoach")Coach coach,@Qualifier("baseballCoach")Coach theAnotherCoach){
    myCoach =coach;
    anotherCoach =theAnotherCoach;
}


@GetMapping("/check")
public String check(){
    return "Comparing Beans: "+(myCoach == anotherCoach);
}

    @GetMapping("/dailyworkout")
    public String  getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
