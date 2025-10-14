package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/main")
    public String loginPage(@RequestParam String username, @RequestParam String password ) {
        System.out.println("username="+ username);
        System.out.println("password="+ password);
        return null;
    }
}
