package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "member")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any more code
    // http://localhost:8080/api/employees?page=0&size=2

}
