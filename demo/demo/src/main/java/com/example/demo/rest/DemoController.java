package com.example.demo.rest;

import com.example.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Coach anotherCoach;

    //constructor injection
    //for Qualifier annotation --> we need to add same class name only first letter is lowerCase
//    @Autowired
//    public DemoController(@Qualifier("footballCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

    //setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){ // we can give any method name
//        myCoach = theCoach;
//    }

    // here we use primary for multiple impl class
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }

    //for lazy initialization
//    @Autowired
//    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
//        System.out.println("class name is  " + getClass());
//        myCoach = theCoach;
//        System.out.println("class name is  " + myCoach.getClass());
//    }


    //check the scope of bean
    //by default it is Singleton but we can change by adding @Scope
//    @Autowired
//    public DemoController(@Qualifier("tennisCoach") Coach theCoach , @Qualifier("tennisCoach") Coach anothrCoach){
//        System.out.println("class name is  " + getClass());
//        myCoach = theCoach;
//        anotherCoach = anothrCoach;
//        System.out.println("class name is  " + myCoach.getClass() + " another " + anotherCoach.getClass()) ;
//    }

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("class name is  " + getClass());
        myCoach = theCoach;
        System.out.println("class name is  " + myCoach.getClass()) ;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public  String check(){
        //return true if scope is Singleton
        //return false if scope is other than Singleton
        return  "Comapre beans  " + (myCoach == anotherCoach);
    }


}
