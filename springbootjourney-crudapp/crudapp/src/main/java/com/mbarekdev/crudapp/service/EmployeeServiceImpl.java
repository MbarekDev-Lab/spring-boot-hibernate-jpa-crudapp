package com.mbarekdev.crudapp.service;

import com.mbarekdev.crudapp.dao.EmployeeDAO;
import com.mbarekdev.crudapp.entity.Employee;
import com.mbarekdev.crudapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();

    }

    @Override
    public void save(Student theStudent) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public List<Employee> findByLastName(String theLastName) {
        return List.of();
    }

    @Override
    public void update(Employee student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
