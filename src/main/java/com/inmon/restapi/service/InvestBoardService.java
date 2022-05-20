package com.inmon.restapi.service;

import com.inmon.restapi.entity.member.Member;
import com.inmon.restapi.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvestBoardService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Map insertUser(Member member){
        Map result = new HashMap();
        Member member1 = memberRepository.findByUserId(member.getUserId());
        if(member1!=null) {
            result.put("message","이미 가입된 아이디");
        }else{
            member.setUserPass(passwordEncoder.encode(member.getUserPass()));
            Member rst = memberRepository.save(member);
            result.put("message","가입성공");
        }

        return result;
    }
}
