package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
