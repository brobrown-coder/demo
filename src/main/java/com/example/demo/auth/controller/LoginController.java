package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.service.LoginService;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/logincontroller")
    public String loginPage(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password ) {
        System.out.println("logincontroller로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 아이디:"+ username);
        System.out.println("화면에서 컨트롤러로 전달된 비밀번호:" + password);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(username);
        loginDTO.setPassword(password);

        loginService.login(loginDTO);

        return "index";
    }
}
