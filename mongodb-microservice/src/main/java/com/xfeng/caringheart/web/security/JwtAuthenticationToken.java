package com.xfeng.caringheart.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4833246934970541381L;

	public JwtAuthenticationToken(String username, String password) {
		super(username, password);
	}

}
