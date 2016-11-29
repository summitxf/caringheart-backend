package com.xfeng.caringheart.web.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.xfeng.caringheart.web.dto.User;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	public JwtAuthenticationFilter(RequestMatcher matcher) {
		super(matcher);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenMissingException("No JWT token found in request headers");
		}

		String jwtToken = header.substring(7);
		if (jwtUtil.isTokenExpired(jwtToken)) {
			throw new JwtTokenMissingException("Token is expired");
		}
		
		User user = jwtUtil.parseToken(jwtToken);
		JwtAuthenticationToken authRequest = new JwtAuthenticationToken(user.getUsername(), user.getPassword());

		return getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authResult);
		SecurityContextHolder.setContext(context);
		chain.doFilter(request, response);
	}
}