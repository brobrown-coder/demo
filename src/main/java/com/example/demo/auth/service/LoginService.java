package com.example.demo.auth.service;

import org.springframework.stereotype.Service;
import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.domain.LoginVO;
import com.example.demo.common.domain.Messenger;

@Service
public class LoginService {
    public Messenger login(LoginDTO loginDTO) {
        System.out.println("로그인서비스로 들어옴");
        System.out.println("DTO에서 전달된 이메일:" + loginDTO.getUsername());
        System.out.println("DTO에서 전달된 비밀번호:" + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();

        System.out.println("VO에서 전달된 아이디:" + loginVO.getUsername());
        System.out.println("VO에서 전달된 비밀번호:" + loginVO.getPassword());

        // 디폴트
        int code = 0;
        String message = "";

        // 아이디와 비밀번호가 모두 일치하는 경우
        if (loginVO.getUsername().equals(loginDTO.getUsername())
                && loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 0; // 로그인 성공
            message = "로그인 성공";
        }
        // 아이디는 일치하지만 비밀번호가 일치하지 않는 경우
        else if (loginVO.getUsername().equals(loginDTO.getUsername())
                && !loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 1; // 비밀번호 불일치
            message = "비밀번호 불일치";
        }
        // 아이디가 일치하지 않는 경우
        else {
            code = 2; // 아이디 불일치
            message = "아이디 불일치";
        }

        Messenger messenger = new Messenger();
        messenger.setCode(code);
        messenger.setMessage(message);

        return messenger;
    }
}
