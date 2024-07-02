package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("class is " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "practise batting and bowling for 15min wow!!!!! ";
    }
}
