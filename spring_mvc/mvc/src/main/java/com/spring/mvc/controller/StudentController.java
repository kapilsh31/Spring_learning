package com.spring.mvc.controller;

import com.spring.mvc.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${language}")
    private List<String> language;

    @Value("${opsystem}")
    private List<String> opsystem;

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String show(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries); // drop down
        model.addAttribute("language", language); // radio button
        model.addAttribute("opsystem", opsystem); // checkbox
        return "showForm";
    }

    @PostMapping("/formDetails")
    public String getFormDtls(@Valid @ModelAttribute("student") Student student, BindingResult bind){
        if(bind.hasErrors()){
            return "showForm";
        }

        System.out.println("student first name and last name is " + student.getFname() + " " + student.getLname());
        return "getForm";
    }

}
