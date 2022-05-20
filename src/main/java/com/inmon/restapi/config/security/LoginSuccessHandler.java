package com.inmon.restapi.config.security;

import com.inmon.restapi.repository.member.MemberRepository;
import com.inmon.restapi.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private MemberService userService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String accept = request.getHeader("accept");
        String id = authentication.getName();

        if( StringUtils.indexOf(accept, "json") > -1 ) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(200);
            String data = StringUtils.join(new String[] {
                    " { \"response\" : {",
                    " \"status\" : 200 , ",
                    " \"message\" : \"로그인하였습니다.\" ,",
                    " \"Token\" : \""+jwtTokenUtil.generateToken(id)+"\"",
                    "} } "
            });

            PrintWriter out = response.getWriter();
            out.print(data);
            out.flush();
            out.close();
        }
    }
}
