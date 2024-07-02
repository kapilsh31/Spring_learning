package com.restcrud.restcrud.rest;

import com.restcrud.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestCOntroller {

    private List<Student> theStudent;

    //define @postconstruct to load data
    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("kapil", "sharma"));
        theStudent.add(new Student("himanshu", "garg"));
    }

    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= theStudent.size() || studentId < 0){
            throw new StudentNotFoundException("student id not found " + studentId);
        }

        return theStudent.get(studentId); // id is same as index of list
    }




}
