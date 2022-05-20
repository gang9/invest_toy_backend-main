package com.inmon.restapi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
//	@Autowired
//	private LoginDao loginDao;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
        errMessage(request);
        request.getRequestDispatcher("").forward(request, response);
	}

	public void errMessage(HttpServletRequest request) {
		request.setAttribute("message", "로그인에 실패했습니다.");
	}
}
