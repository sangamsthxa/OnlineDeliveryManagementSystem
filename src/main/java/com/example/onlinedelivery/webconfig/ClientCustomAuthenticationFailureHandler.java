package com.example.onlinedelivery.webconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class ClientCustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
		
		response.sendRedirect("/login?error=Username and Password Wrong");

	}
}
