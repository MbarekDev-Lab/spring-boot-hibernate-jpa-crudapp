package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager ;
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        // entityManager.merge(theStudent);
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // All JPQL syntax is based on entity name and entity fields
        //TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student ", Student.class);
        //TypedQuery<Student> typedQuery =  entityManager.createQuery("SELECT s FROM Student s", Student.class);
        // TypedQuery<Student> typedQuery = entityManager.createQuery("SELECT S FROM Student S WHERE S.email LIKE'%mbarekDev,com'", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create a query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters ( lastName=:theData)
        typedQuery.setParameter("theData", theLastName);


        // return query result;

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
