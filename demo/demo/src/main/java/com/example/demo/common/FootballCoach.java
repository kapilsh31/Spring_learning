package com.example.demo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy  npw only initialize if we want
//@Primary  if we need to make specific
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("class is " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "practise Football  for 15min wow!!!!! ";
    }
}
