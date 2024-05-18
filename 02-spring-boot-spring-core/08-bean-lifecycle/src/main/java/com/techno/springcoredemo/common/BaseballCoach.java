package com.techno.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

  public   BaseballCoach(){
      System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practise";
    }

    //define our init method
    @PostConstruct
    public void domyStart(){
        System.out.println("in my init method: "+getClass().getSimpleName());
    }
// define destroy fun

@PreDestroy
    public void domyCleanup(){
    System.out.println("in my Destroy method: "+getClass().getSimpleName());
}
}
