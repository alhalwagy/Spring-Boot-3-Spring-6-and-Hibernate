package com.techno.springcoredemo.common;



public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("in constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swimming for 60 minutes.";
    }
}
