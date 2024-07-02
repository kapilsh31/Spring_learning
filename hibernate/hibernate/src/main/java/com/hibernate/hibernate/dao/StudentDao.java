package com.hibernate.hibernate.dao;

import com.hibernate.hibernate.entity.Student;

import java.util.List;

public interface StudentDao {

    // interface class of DAO implementation class
    //here we pass the entity class
    void save(Student theStudent);

    //find by id
    Student findById(Integer id);

    //find all student
    List<Student> findAll();

    //find student by lastName
    List<Student> findByLastName(String lastName);

    //update value
    void update(Student theStudent);

    //delete obj from db
    void delete(Integer id);

    //delete all
    int deleteAll();
}
