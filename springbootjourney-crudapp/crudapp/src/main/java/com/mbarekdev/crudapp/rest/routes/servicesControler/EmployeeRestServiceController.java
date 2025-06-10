package com.mbarekdev.crudapp.rest.routes.servicesControler;

import com.mbarekdev.crudapp.entity.Employee;
import com.mbarekdev.crudapp.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class EmployeeRestServiceController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestServiceController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees_service")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee emp = employeeService.findById(employeeId);
        if (emp == null) throw new RuntimeException("Not found: " + employeeId);
        return emp;
    }


    // add mapping for POST /employee - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}
