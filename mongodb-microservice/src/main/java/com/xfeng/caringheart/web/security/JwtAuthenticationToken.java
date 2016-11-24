package com.xfeng.caringheart.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	public JwtAuthenticationToken(String username, String password) {
		super(username, password);
	}

}
