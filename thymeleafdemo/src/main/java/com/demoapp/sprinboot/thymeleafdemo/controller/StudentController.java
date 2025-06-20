package com.demoapp.sprinboot.thymeleafdemo.controller;

import com.demoapp.sprinboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        // Create a student object
        Student theStudent = new Student();
        // Add a student object to the model
        theModel.addAttribute("student", theStudent);
        return "student-form";  // Thymeleaf template name
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        // Log the input data to console
        System.out.println("Student: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";  // Confirmation page template name
    }
}
