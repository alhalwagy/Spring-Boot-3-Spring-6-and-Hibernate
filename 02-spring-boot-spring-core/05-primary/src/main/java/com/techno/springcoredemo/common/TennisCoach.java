package com.techno.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley";
    }
}
