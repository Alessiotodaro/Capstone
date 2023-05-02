package com.example.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/aboutus")
    public String showAboutUsPage(){
        return "aboutus";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/registrati")
    public String showRegisterPage(){
        return "registrati";
    }

}
