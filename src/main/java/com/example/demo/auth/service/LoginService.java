package com.example.demo.auth.service;

import org.springframework.stereotype.Service;
import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.domain.LoginVO;

@Service
public class LoginService {
    public boolean login(LoginDTO loginDTO) {
        System.out.println("로그인서비스로 들어옴");
        System.out.println("DTO에서 전달된 이메일:" + loginDTO.getUsername());
        System.out.println("DTO에서 전달된 비밀번호:" + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();

        System.out.println("VO에서 전달된 아이디:" + loginVO.getUsername());
        System.out.println("VO에서 전달된 비밀번호:" + loginVO.getPassword());


        if(loginVO.getUsername().equals(loginDTO.getUsername()) && loginVO.getPassword().equals(loginDTO.getPassword())) {
            return true;
        }
        else {
            return false;
        }   
    }
}
