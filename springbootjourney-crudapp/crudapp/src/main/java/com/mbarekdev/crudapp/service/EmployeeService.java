package com.mbarekdev.crudapp.service;

import com.mbarekdev.crudapp.entity.Employee;
import com.mbarekdev.crudapp.entity.Student;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Student theStudent);

    Employee findById(int id);

    List<Employee> findByLastName(String theLastName);

    void update(Employee student);

    void delete(int id);

    int deleteAll();
}
