package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public  String sayHello(Model model){
        //here we store date in variable named date which is attribute in model
        model.addAttribute("date" , java.time.LocalDateTime.now());
        return "sayhello";
    }

    //this is method to go forward
    @RequestMapping("/displayHello")
    public String getHello(){
        return "getHello";
    }

}
