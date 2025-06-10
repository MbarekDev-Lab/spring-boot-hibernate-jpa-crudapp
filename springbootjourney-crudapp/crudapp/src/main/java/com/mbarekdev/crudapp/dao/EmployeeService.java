package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee theEmployee);

    Employee findById(int id);

    List<Employee> findByLastName(String theLastName);

    void update(Employee student);

    void deleteById(int id);

    void deleteById();

    int deleteAll();
}
