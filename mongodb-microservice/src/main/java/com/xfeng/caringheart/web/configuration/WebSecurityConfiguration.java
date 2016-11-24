package com.xfeng.caringheart.web.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.xfeng.caringheart.web.security.JwtAuthenticationFilter;
import com.xfeng.caringheart.web.security.JwtAuthenticationProvider;
import com.xfeng.caringheart.web.security.RestAuthenticationEntryPoint;
import com.xfeng.caringheart.web.security.SkipPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint unauthorizedHandler;
	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	protected JwtAuthenticationFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception {
		List<String> pathsToSkip = Arrays.asList("/user/signin", "/user/signup");
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, "/heart/**");
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter(matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // We don't need CSRF for JWT based authentication
				.exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler)//

				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//

				.and().authorizeRequests().antMatchers("/user/signin", "/user/signup").permitAll() //

				.and().authorizeRequests().anyRequest().authenticated() //

				.and().addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(),
						UsernamePasswordAuthenticationFilter.class);
	}

}
