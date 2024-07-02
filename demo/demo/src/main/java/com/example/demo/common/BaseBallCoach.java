package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach() {
        System.out.println("class is " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "practise baseball for 15min wow!!!!! ";
    }
}
