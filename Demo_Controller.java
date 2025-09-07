package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to My Maven + SonarQube Website");
        model.addAttribute("message", "This site is built with Spring Boot, tested with Maven, and analyzed with SonarQube!");
        return "index";
    }
}
