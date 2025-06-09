package com.mbarekdev.crudapp.rest.controllers;

import com.mbarekdev.crudapp.entity.Employee;
import com.mbarekdev.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestServiceController {
    private final EmployeeService theEmployeeService;


    // Constructor-based dependency injection
    @Autowired
    public EmployeeRestServiceController(EmployeeService theEmployeeService) {
        this.theEmployeeService = theEmployeeService;
    }

    // GET /api/employees
    @GetMapping("/employees_service")
    public List<Employee> findAll() {
        return theEmployeeService.findAll();
    }

}
