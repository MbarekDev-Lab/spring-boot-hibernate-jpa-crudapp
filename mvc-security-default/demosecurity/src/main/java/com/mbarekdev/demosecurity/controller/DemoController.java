package com.mbarekdev.demosecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }
    // add a  request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    // add a request mapping for /leaders
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    // add a request mapping for / manager
    @GetMapping("/manager")
    public String showManager() {
        return "manager";
    }
}
