package com.xfeng.caringheart.web.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * An {@link AuthenticationProvider} implementation that will use provided
 * instance of {@link JwtToken} to perform authentication.
 * 
 * @author vladimir.stankovic
 *
 *         Aug 5, 2016
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
		return new JwtAuthenticationToken(username, password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
