package com.mbarekDev.cruddemo.dao;

import com.mbarekDev.cruddemo.entity.Instructor;
import com.mbarekDev.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);


}
