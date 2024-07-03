package com.restapi.restapi.dao;

import com.restapi.restapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee ,Integer> {

    //parameter
    //1 -- entity class
    //2 -- primary key

//    public List<Employee> findAllByOrderBylast_nameAsc();
}
