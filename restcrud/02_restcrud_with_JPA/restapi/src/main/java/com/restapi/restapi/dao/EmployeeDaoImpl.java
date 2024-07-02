package com.restapi.restapi.dao;

import com.restapi.restapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> myQury = entityManager.createQuery("FROM Employee ", Employee.class);
        List<Employee> emp =  myQury.getResultList();
        return emp;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class , id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmpl = entityManager.merge(theEmployee);
        //if id  == 0 then insert else save
        return dbEmpl;
    }

    @Override
    public void deleteById(int id) {
        Employee myEmployee = entityManager.find(Employee.class , id);
        entityManager.remove(myEmployee);
    }
}
