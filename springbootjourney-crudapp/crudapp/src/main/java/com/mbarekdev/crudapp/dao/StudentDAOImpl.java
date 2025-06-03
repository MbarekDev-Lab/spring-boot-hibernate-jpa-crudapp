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
        // "FROM Student s WHERE LOWER(s.lastName) LIKE LOWER(:theData)" // searching with case-insensitivity
        // typedQuery.setParameter("theData", "%" + theLastName + "%");

        // Create a typed JPQL query
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student s WHERE s.lastName = :theData", Student.class
        );

        // Set the parameter for lastName
        typedQuery.setParameter("theData", theLastName);

        // Execute and return results
        return typedQuery.getResultList();
    }


    @Override
    @Transactional // adding the transactinal annotation since we are performing an update
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional // adding the transactinal annotation since we are performing a deleted
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
