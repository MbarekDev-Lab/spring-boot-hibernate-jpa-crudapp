package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();

}
