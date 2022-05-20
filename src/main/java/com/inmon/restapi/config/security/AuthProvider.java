package com.inmon.restapi.config.security;

import com.inmon.restapi.entity.member.Member;
import com.inmon.restapi.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wedul
 *
 */
@Slf4j
@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    MemberRepository memberRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    // 1step
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        HttpServletRequest request = request();
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        log.info("authentication ====> "+ authentication.getCredentials().toString());
//        String role = request.getParameter("role");
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        return authenticate(id, password, "");
	}

    // 2step
    public Authentication authenticate(String id, String password, String role) throws AuthenticationException {
        // 일반유저 로그인 시
        Member member = memberRepository.findByUserId(id);
        role = "ADMIN";
        if (member == null) {
        	throw new UsernameNotFoundException("id not matched");
        } else if (!passwordEncoder.matches(password, member.getUserPass())) {
        	throw new BadCredentialsException("password not matched");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        grantedAuthorityList.add(new SimpleGrantedAuthority(role));
        return new MyAuthenticaion(id, password, grantedAuthorityList, member);

        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * HttpServletRequest 반환
     *
     * @return HttpServletRequest
     */
    private HttpServletRequest request() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

}
