package com.inmon.restapi.config.security;

import com.inmon.restapi.entity.member.Member;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
    private  static final long serialVersionUID = 1L;

    Member member;

    public MyAuthenticaion(String id, String password, List<GrantedAuthority> grantedAuthorityList, Member member) {
        super(id, password, grantedAuthorityList);
        this.member = member;
    }

}