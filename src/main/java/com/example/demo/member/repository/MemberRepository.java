package com.example.demo.member.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.common.domain.Messenger;
import com.example.demo.member.domain.MemberDTO;
import com.example.demo.member.service.MemberService;

@Repository
public class MemberRepository implements MemberService {

    
    public Messenger save(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'join'");
    }

    
    public Messenger update(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    
    public Messenger delete(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    
    public Messenger findByID(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    public Messenger findAll(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
