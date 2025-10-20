package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.service.LoginService;
import com.example.demo.common.domain.Messenger;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logincontroller")
    public String loginPage(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            Model model) {
        System.out.println("logincontroller로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 아이디:" + username);
        System.out.println("화면에서 컨트롤러로 전달된 비밀번호:" + password);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(username);
        loginDTO.setPassword(password);

        Messenger messenger = loginService.login(loginDTO);
        System.out.println("서비스에서 컨트롤러로 리턴한코드: " + messenger.getCode());
        System.out.println("서비스에서 컨트롤러로 리턴한메시지: " + messenger.getMessage());

        model.addAttribute("messenger", messenger);

        return "index";
    }
}
