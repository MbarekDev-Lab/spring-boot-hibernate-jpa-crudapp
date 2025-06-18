package com.demoapp.sprinboot.thymeleafdemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorkdController {

    // Controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    // Controller method to process the form input
    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String theName, Model model) {
        // Convert data to uppercase and create a message
        String result = "Student Name:  " + theName.toUpperCase();

        // Add the message to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }
}
