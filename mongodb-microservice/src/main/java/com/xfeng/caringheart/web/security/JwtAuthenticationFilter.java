package com.xfeng.caringheart.web.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
		User user = jwtUtil.parseToken(jwtToken);
		JwtAuthenticationToken authRequest = new JwtAuthenticationToken(user.getUsername(), user.getPassword());

		return getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);

		// As this authentication is in HTTP header, after success we need to
		// continue the request normally
		// and return the response as if the resource was not secured at all
		chain.doFilter(request, response);
	}
}