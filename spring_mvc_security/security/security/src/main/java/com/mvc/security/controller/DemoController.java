package com.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String getLeader(){
        return "leader";
    }

    @GetMapping("/systems")
    public String getLAdmin(){
        return "system";
    }

}
