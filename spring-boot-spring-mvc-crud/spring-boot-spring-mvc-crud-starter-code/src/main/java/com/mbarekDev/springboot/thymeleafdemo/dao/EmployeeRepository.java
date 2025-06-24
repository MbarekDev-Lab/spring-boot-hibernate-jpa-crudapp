package com.mbarekDev.springboot.thymeleafdemo.dao;

import com.mbarekDev.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // add method to sort with lastName
    public List<Employee> findAllByOrderByLastNameAsc();
//    default List<Employee> findAllByLastNameAsc() {
//        return findAll(Sort.by(Sort.Direction.ASC, "lastName"));
//    }

}
