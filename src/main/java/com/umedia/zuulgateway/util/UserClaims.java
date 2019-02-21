package com.umedia.zuulgateway.util;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.jwt.JwtHelper;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserClaims {

	private String oid;
	private String email;
	private int expired;
	private String issuer;
	private String audience;

	@SuppressWarnings("unchecked")
	public UserClaims(Object claims) {
		if (claims instanceof Map)
			init((Map<String, Object>) claims);
	}

	public UserClaims(Map<String, Object> claims) {
		init(claims);
	}

	private void init(Map<String, Object> claims) {
		this.setOid((String) claims.get("oid"));
		@SuppressWarnings("unchecked")
		List<String> emails = (List<String>) claims.get("emails");
		if (emails.size() > 0)
			this.setEmail(emails.get(0));

		setExpired((int) claims.get("exp"));
		setAudience((String) claims.get("aud"));
		setIssuer((String) claims.get("iss"));
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getOid() {
		return oid;
	}

	private void setOid(String oid) {
		this.oid = oid;
	}

	public int getExpired() {
		return expired;
	}

	private void setExpired(int expired) {
		this.expired = expired;
	}

	public String getIssuer() {
		return issuer;
	}

	private void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getAudience() {
		return audience;
	}

	private void setAudience(String audience) {
		this.audience = audience;
	}

	@SuppressWarnings("unchecked")
	public static UserClaims getUserClaims(HttpServletRequest request) throws ServletException {
		final String authHeader = request.getHeader("Authorization");
		if (StringUtils.isEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
			throw new ServletException("Missing or invalid Authorization header.");
		}

		final String idToken = authHeader.substring(7);

		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> claimsMap = mapper.readValue(JwtHelper.decode(idToken).getClaims(), Map.class);
			return new UserClaims(claimsMap);
		} catch (Exception ex) {
			throw new ServletException("User claims parse error.", ex);
		}
	}
}
