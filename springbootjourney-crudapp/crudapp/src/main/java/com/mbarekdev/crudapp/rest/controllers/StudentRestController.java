package com.mbarekdev.crudapp.rest.controllers;

import com.mbarekdev.crudapp.dao.StudentDAO;
import com.mbarekdev.crudapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/*@RestController
@RequestMapping("/stud")
public class StudentRestController {
    private final StudentDAO studentDAO;
    private List<Student> mockStudents;

    @Autowired
    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Optional: Load mock data for demonstration (not from DB)
    @PostConstruct
    public void loadMockData() {
        mockStudents = new ArrayList<>();
        mockStudents.add(new Student("Sara", "Saradev", "sara@DevCode.com"));
        mockStudents.add(new Student("David", "Dev", "david@DevCode.com"));
        mockStudents.add(new Student("Grace", "Green", "grace@DevCode.com"));
    }

    // Return all students from the database
    @GetMapping("/students")
    public List<Student> getAllStudentsFromDB() {
        return studentDAO.findAll();
    }

    // Return mock students (demo only)
    @GetMapping("/mock-students")
    public List<Student> getMockStudents() {
        return mockStudents;
    }

    // Return a single mock student by index
    @GetMapping("/mock-students/{id}")
    public Student getMockStudentById(@PathVariable int studentId) {
        if ((studentId < 0) || (studentId >= mockStudents.size())) {
            throw new RuntimeException("Student ID not found: " + studentId);
        }
        return mockStudents.get(studentId);
    }




}*/
