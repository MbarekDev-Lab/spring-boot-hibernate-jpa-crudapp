package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
