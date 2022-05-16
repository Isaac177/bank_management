package com.example.isaacbank.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


 //Let's map the /login and /403 URLs to the login.html and 403.html views respectively by using Thymeleaf.

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login(){

        return "login";
    }
    @RequestMapping("/403")
    public String accessDined(){

        return "403";
    }
}
