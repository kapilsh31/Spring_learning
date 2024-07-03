package com.restapi.restapi.controller;

import com.restapi.restapi.entity.Employee;
import com.restapi.restapi.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getList(Model model){

        //get employees from db and add to model
        List<Employee> theEmployee = employeeService.findAll();

        model.addAttribute("employees", theEmployee);

        return "employees/list-employees";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployee(Model model){
        Employee theEmployee  = new Employee();
        model.addAttribute("employee", theEmployee);
        return "employees/add-employee";
    }

    @GetMapping("/showFormForUpdate")
    public  String showFormForUpdate(@RequestParam("id") int theId, Model model){

        //get the empl details from id
        Employee employee = employeeService.findById(theId);

        model.addAttribute("employee" , employee);

        return "/employees/add-employee";

    }

    @GetMapping("/delete")
    public  String deleteEmployee(@RequestParam("id") int theId){

        //get the empl details from id
        employeeService.deleteById(theId);

        return "redirect:/employees/list";

    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee){
        Employee dbEmpl = employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

}
