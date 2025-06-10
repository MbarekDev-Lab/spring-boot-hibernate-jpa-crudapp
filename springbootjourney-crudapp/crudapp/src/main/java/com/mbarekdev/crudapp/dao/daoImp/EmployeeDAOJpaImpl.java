package com.mbarekdev.crudapp.dao.daoImp;

import com.mbarekdev.crudapp.dao.EmployeeDAO;
import com.mbarekdev.crudapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
//
//@Repository
//@Lazy
//public class EmployeeDAOJpaImpl implements EmployeeDAO {
//
//    private final EntityManager entityManager;
//
//    @Autowired
//    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
//        this.entityManager = theEntityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ", Employee.class);
//        return theQuery.getResultList();
//    }
//
//    @Override
//    public Employee save(Employee theEmployee) {
//        return entityManager.merge(theEmployee);
//    }
//}
