package com.mbarekDev.springboot.thymeleafdemo.controller;

import com.mbarekDev.springboot.thymeleafdemo.entity.Employee;
import com.mbarekDev.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        //get the employees from db;
        List<Employee> theEmployees = employeeService.findAll();
        //add that to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    //<a th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        //get the Employee from the service
        Employee theEmloyee = employeeService.findById(theId);
        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmloyee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int theId) {
        //delete the Employee ;
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }


}
