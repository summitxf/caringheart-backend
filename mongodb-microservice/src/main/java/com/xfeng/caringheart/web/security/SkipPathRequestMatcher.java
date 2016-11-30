package com.xfeng.caringheart.web.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

public class SkipPathRequestMatcher implements RequestMatcher {
	private OrRequestMatcher skipMatchers;
	private RequestMatcher processingMatcher;

	public SkipPathRequestMatcher(List<String> pathsToSkip, String processingPath) {
		Assert.notNull(pathsToSkip);

		List<RequestMatcher> m = new ArrayList<RequestMatcher>();
		for (String path : pathsToSkip) {
			m.add(new AntPathRequestMatcher(path));
		}

		skipMatchers = new OrRequestMatcher(m);
		processingMatcher = new AntPathRequestMatcher(processingPath);
	}

	@Override
	public boolean matches(HttpServletRequest request) {
		if (skipMatchers.matches(request)) {
			return false;
		}
		return processingMatcher.matches(request);
	}
}
