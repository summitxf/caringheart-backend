package com.xfeng.caringheart.web.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xfeng.caringheart.web.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + this.expiration * 1000);
	}

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns
	 * User object with username, id and role prefilled (extracted from token).
	 * If unsuccessful (token is invalid or not containing all required user
	 * properties), simply returns null.
	 * 
	 * @param token
	 *            the JWT token to parse
	 * @return the User object extracted from specified token or null if a token
	 *         is invalid.
	 */
	public User parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			User u = new User();
			u.setUsername(body.getSubject());
			u.setId((String) body.get("userId"));
			u.setPassword((String) body.get("password"));

			return u;

		} catch (Exception e) {
			throw new JwtTokenMissingException("Invalid token");
		}
	}

	/**
	 * Generates a JWT token containing username as subject, and userId and role
	 * as additional claims. These properties are taken from the specified User
	 * object. Tokens validity is infinite.
	 * 
	 * @param u
	 *            the user for which the token will be generated
	 * @return the JWT token
	 */
	public String generateToken(User u) {
		Claims claims = Jwts.claims().setSubject(u.getUsername());
		claims.put("userId", u.getId());
		claims.put("password", u.getPassword());
		claims.put("created", this.generateCurrentDate());

		return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Boolean isTokenExpired(String token) {
		final Claims claims = this.getClaimsFromToken(token);
		final Date expiredDate = claims.getExpiration();
		return expiredDate.before(this.generateCurrentDate());
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) {
			throw new JwtTokenMissingException("Token is expired");
		} catch (UnsupportedJwtException e) {
			throw new JwtTokenMissingException("Invalid token");
		} catch (MalformedJwtException e) {
			throw new JwtTokenMissingException("Invalid token");
		} catch (SignatureException e) {
			throw new JwtTokenMissingException("Invalid token");
		} catch (IllegalArgumentException e) {
			throw new JwtTokenMissingException("Invalid token");
		}
		return claims;
	}

	public String refreshToken(String token) {
		final Claims claims = this.getClaimsFromToken(token);
		claims.put("created", this.generateCurrentDate());

		return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}
}