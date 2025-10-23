package com.example.demo.member.service;

import com.example.demo.common.domain.Messenger;
import com.example.demo.member.domain.MemberDTO;

public interface MemberService {

    Messenger save(MemberDTO memberDTO);

    Messenger update(MemberDTO memberDTO);

    Messenger delete(MemberDTO memberDTO);

    Messenger findByID(MemberDTO memberDTO);

    Messenger findAll(MemberDTO memberDTO);

}
