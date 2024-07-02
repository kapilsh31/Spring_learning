package com.hibernate.hibernate.dao;


import com.hibernate.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements  StudentDao{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // as we are performing update
    public void save(Student theStudent) {
        entityManager.persist(theStudent); //method call for save object in db
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class , id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> myQury = entityManager.createQuery("FROM Student order by last_name desc", Student.class);
        return  myQury.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> myQury = entityManager.createQuery("FROM Student where last_name =:theName", Student.class);
        myQury.setParameter("theName", lastName);
        return  myQury.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student myStudent = entityManager.find(Student.class , id);
        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int norRow = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return  norRow;
    }


}
