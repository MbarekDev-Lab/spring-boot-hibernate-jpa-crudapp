package com.demoapp.sprinboot.thymeleafdemo.controller;

import com.demoapp.sprinboot.thymeleafdemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    /**
     * Controller method to display the initial HTML form.
     * This method handles GET requests to /showForm and returns the form view.
     */
    @GetMapping("/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    /**
     * Controller method to process form submission (supports both GET and POST).
     * Reads the student name, converts it to uppercase, and adds a greeting message to the model.
     *
     * @param name  The name entered in the form (studentName input)
     * @param model Spring's model to pass data to the view
     * @return the view name (helloWorld)
     */
    @RequestMapping(value = "/processForm", method = {RequestMethod.GET, RequestMethod.POST})
    public String processForm(@RequestParam("studentName") String name, Model model) {
        String message = "Hello " + name.toUpperCase();
        model.addAttribute("message", message);
        return "helloWorld";
    }

    /**
     * Controller method to process form using HttpServletRequest.
     * Demonstrates manual parameter extraction and basic null/blank check.
     *
     * @param request The HTTP request object to get parameters
     * @param model   The model to pass data to the view
     * @return the view name (helloWorld)
     */
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");
        // Handle missing or blank name
        if (theName == null || theName.isBlank()) {
            theName = "Guest";
        }

        String result = "Yo! " + theName.toUpperCase();
        model.addAttribute("message2", result);
        return "helloWorld";
    }

    /**
     * Controller method to a process form using @RequestParam with default fallback.
     * A more idiomatic way using Spring to safely retrieve and process input.
     *
     * @param theName The student name from the form
     * @param model   The model to pass data to the view
     * @return the view name (helloWorld)
     */
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam(value = "studentName", required = false) String theName, Model model) {
        if (theName == null || theName.isBlank()) {
            theName = "Guest";
        }
        String result = "Yo! " + theName.toUpperCase();
        model.addAttribute("message2", result);
        return "helloWorld";
    }


}
