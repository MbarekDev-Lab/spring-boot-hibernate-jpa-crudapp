package com.mbarekdev.crudapp.service;

import com.mbarekdev.crudapp.dao.EmployeeRepository;
import com.mbarekdev.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // no employee found that
            throw new RuntimeException("did not find Employee id-> " + id);
        }
        return theEmployee;
        // return result.orElseThrow(() -> new RuntimeException(" - " + id));

    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee savedd(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
