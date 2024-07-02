package com.restapi.restapi.rest;

import com.restapi.restapi.dao.EmployeeDao;
import com.restapi.restapi.entity.Employee;
import com.restapi.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //private EmployeeDao employeeDao;
    private EmployeeService employeeService;

//    public EmployeeRestController(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId){
        Employee dbEmpl = employeeService.findById(empId);

        if(dbEmpl   == null ){
            throw new RuntimeException("student id not found with this id " + empId);
        }

        return dbEmpl;
    }

    @PostMapping("/employees")
    public Employee addEmpl(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmpl = employeeService.save(employee);
        return dbEmpl;
    }

    @PutMapping("/employees")
    public Employee updateEmpl(@RequestBody Employee employee){
        Employee dbEmpl = employeeService.save(employee);
        return dbEmpl;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmpl(@PathVariable int employeeId){

        Employee dbEmpl = employeeService.findById(employeeId);

        if(dbEmpl   == null ){
            throw new RuntimeException("student id not found with this id " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return ("Employee deleted " + employeeId);
    }
}
