package com.mbarekdev.crudapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mbarekdev.crudapp.entity.Employee;
import com.mbarekdev.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper theObjectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0); // force insert
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }

    // PATCH: Partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {

        Employee existingEmployee = employeeService.findById(employeeId);

        if (existingEmployee == null) {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Modification of 'id' field is not allowed.");
        }

        Employee patchedEmployee = applyPatch(patchPayload, existingEmployee);
        return employeeService.save(patchedEmployee);
    }

    private Employee applyPatch(Map<String, Object> patchPayload, Employee targetEmployee) {
        // Convert current Employee to JSON ObjectNode
        ObjectNode employeeNode = objectMapper.convertValue(targetEmployee, ObjectNode.class);
        // Convert patch map to ObjectNode
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        // Apply patch: merge patchNode into employeeNode
        employeeNode.setAll(patchNode);
        // Convert back to Employee
        return objectMapper.convertValue(employeeNode, Employee.class);
    }


}
