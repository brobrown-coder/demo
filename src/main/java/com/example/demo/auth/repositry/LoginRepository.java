package com.example.demo.auth.repositry;

import org.springframework.stereotype.Repository;

import com.example.demo.auth.domain.LoginEntity;
import com.example.demo.auth.domain.LoginDTO;
import com.example.demo.auth.domain.LoginVO;
import com.example.demo.common.domain.Messenger;

@Repository
public class LoginRepository {

    public Messenger login(LoginEntity loginEntity) {
        return null;
    }

    // DTO 값을 Repository 계층에서 확인하기 위한 메서드
    public void printLogin(LoginDTO loginDTO) {
        System.out.println("[Repository] 전달된 아이디: " + loginDTO.getUsername());
        System.out.println("[Repository] 전달된 비밀번호: " + loginDTO.getPassword());
    }

    // 로그인 결과를 생성하여 반환
    public Messenger login(LoginDTO loginDTO, LoginVO loginVO) {
        System.out.println("[Repository] 로그인 로직 수행 시작");
        System.out.println("[Repository] DTO.username=" + loginDTO.getUsername());
        System.out.println("[Repository] DTO.password=" + loginDTO.getPassword());
        System.out.println("[Repository] VO.username=" + loginVO.getUsername());
        System.out.println("[Repository] VO.password=" + loginVO.getPassword());

        int code;
        String message;

        if (loginVO.getUsername().equals(loginDTO.getUsername())
                && loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 0;
            message = "로그인 성공";
        } else if (loginVO.getUsername().equals(loginDTO.getUsername())
                && !loginVO.getPassword().equals(loginDTO.getPassword())) {
            code = 1;
            message = "비밀번호 불일치";
        } else {
            code = 2;
            message = "아이디 불일치";
        }

        Messenger messenger = new Messenger();
        messenger.setCode(code);
        messenger.setMessage(message);

        System.out.println("[Repository] 결과 code=" + code + ", message=" + message);
        return messenger;
    }

}
