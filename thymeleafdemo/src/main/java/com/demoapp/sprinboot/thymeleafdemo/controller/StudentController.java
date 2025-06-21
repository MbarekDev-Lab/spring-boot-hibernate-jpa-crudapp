package com.demoapp.sprinboot.thymeleafdemo.controller;

import com.demoapp.sprinboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    // @RequestMapping("/processStudentForm") // This maps both GET and POST by default
    // @PostMapping("/processStudentForm") // Accepts only POST
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        // Create a student object
        Student theStudent = new Student();
        // Add a student object to the model
        theModel.addAttribute("student", theStudent);
        // add a List of Countries to the Model
        theModel.addAttribute("countries", countries);
        // add the list of languages to the model:
        theModel.addAttribute("languages", languages) ;
        return "student-form";  // Thymeleaf template name
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        // Log the input data to console
        System.out.println("Student: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " from " + theStudent.getCountry());
        return "student-confirmation";  //Confirmation page template name
    }


}
