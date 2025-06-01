package com.mbarekdev.crudapp.dao;

import com.mbarekdev.crudapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void update(Student student);
    void delete(int id);
}
