package com.spring.mvc.model;

import jakarta.validation.constraints.*;

public class Student {

    @NotNull(message = " is required")
    @Size(min=1, message = " is required")
    private String fname;

    private String lname;

    @NotNull(message=" is required")
    @Min(value=0, message=" must be greater than or equal to zero")
    @Max(value=10, message=" must be less than or equal to 10")
    private Integer number;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private  String country;
    private String language;
    private String opSys;


    public Student(){

    }

    public Student(String fname, String lname, Integer number, String country, String language, String opSys) {
        this.fname = fname;
        this.lname = lname;
        this.number = number;
        this.country = country;
        this.language = language;
        this.opSys = opSys;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }
}
