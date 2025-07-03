package com.mbarekDev.cruddemo.dao;

import com.mbarekDev.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructiorById(int theId);

}
