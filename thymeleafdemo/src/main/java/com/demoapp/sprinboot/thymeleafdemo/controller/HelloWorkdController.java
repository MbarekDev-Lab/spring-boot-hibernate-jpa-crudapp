package com.demoapp.sprinboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    // need controller method to read for data and add data to the modle
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        if (theName == null || theName.isBlank()) {
            theName = "Guest";
        }
        // convert the data to all caps
        theName = theName.toUpperCase();
        // create the message
        String result = "Yo! " + theName;
        // add a message to the model
        model.addAttribute("message2", result);
        return "helloWorld";
    }

    // need controller method to read for data and add data to the modle
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        // read the request parameter from the HTML form
        if (theName == null || theName.isBlank()) {
            theName = "Guest";
        }
        // convert the data to all caps
        theName = theName.toUpperCase();
        // create the message
        String result = "Yo! " + theName;
        // add a message to the model
        model.addAttribute("message2", result);
        return "helloWorld";
    }
}
