package com.xfeng.caringheart.web.dto;

import java.io.Serializable;

public class TokenRsp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3089250249879683584L;
	private String token;

	public TokenRsp(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
