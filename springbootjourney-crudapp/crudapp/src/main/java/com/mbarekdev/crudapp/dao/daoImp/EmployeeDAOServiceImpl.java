package com.mbarekdev.crudapp.dao.daoImp;

import com.mbarekdev.crudapp.dao.EmployeeService;
import com.mbarekdev.crudapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOServiceImpl implements EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        if (emp != null) {
            entityManager.remove(emp);
        }
    }

    @Override
    public void deleteById() {

    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Employee").executeUpdate();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return entityManager.createQuery("FROM Employee e WHERE e.lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public void update(Employee student) {

    }
}
