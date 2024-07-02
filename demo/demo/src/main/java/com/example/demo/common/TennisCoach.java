package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class TennisCoach implements  Coach{

    public TennisCoach() {
        System.out.println("class is " + getClass());
    }

    @PostConstruct //init method
    public String initMethod1(){
        return "calling init method ";
    }

    @PreDestroy // destroy method
    public String dstroyMethod1(){
        return "calling dstroy method ";
    }

    @Override
    public String getDailyWorkout() {
        return "practice Tennis for 15min wow!!!!! ";
    }
}
