package com.example.demo.auth.service;

import org.springframework.stereotype.Service;
import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.domain.LoginVO;
import com.example.demo.auth.repositry.LoginRepository;
import com.example.demo.common.domain.Messenger;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Messenger login(LoginDTO loginDTO) {
        System.out.println("로그인서비스로 들어옴");
        System.out.println("DTO에서 전달된 이메일:" + loginDTO.getUsername());
        System.out.println("DTO에서 전달된 비밀번호:" + loginDTO.getPassword());

        // Repository 계층으로 DTO 전달하여 sysout
        loginRepository.printLogin(loginDTO);

        LoginVO loginVO = new LoginVO();

        System.out.println("VO에서 전달된 아이디:" + loginVO.getUsername());
        System.out.println("VO에서 전달된 비밀번호:" + loginVO.getPassword());

        // Repository에서 Messenger 생성/반환
        return loginRepository.login(loginDTO, loginVO);
    }
}
