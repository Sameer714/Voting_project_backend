package com.techvum.vote.voting.helpers;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPt {
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
				PrintWriter writer = response.getWriter();
				writer.println("Access Denied " + authException.getMessage());
	}

}
