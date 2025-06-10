package com.mbarekdev.crudapp.rest.routes.employeeControllers;

import com.mbarekdev.crudapp.dao.EmployeeDAO;
import com.mbarekdev.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Lazy
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;
    private List<Employee> mockEmployes;

    // Constructor-based dependency injection
    //@Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // GET /api/employees
  //  @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
