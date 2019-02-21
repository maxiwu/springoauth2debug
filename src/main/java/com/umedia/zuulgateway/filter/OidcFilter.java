/*package com.umedia.zuulgateway.filter;

import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umedia.zuulgateway.service.B2CService;
import com.umedia.zuulgateway.service.ClaimsCacheService;
import com.umedia.zuulgateway.util.UserClaims;

@Component
public class OidcFilter extends GenericFilterBean {

	@Autowired
	private B2CService service;

	@Autowired
	private ClaimsCacheService cacheService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		ObjectMapper mapper = new ObjectMapper();

		final String authHeader = req.getHeader("Authorization");
		if (StringUtils.isEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
			throw new ServletException("Missing or invalid Authorization header.");
		}

		final String idToken = authHeader.substring(7); // The part after "Bearer "

		UserClaims claims = cacheService.getClaims(idToken);
		if (claims == null) {
			try {
				Map<String, String> headers = JwtHelper.headers(idToken);
				String kid = headers.get("kid");
				final Jwt tokenDecoded = JwtHelper.decodeAndVerify(idToken, verifier(kid));
				@SuppressWarnings("unchecked")
				final Map<String, Object> authInfo = mapper.readValue(tokenDecoded.getClaims(), Map.class);
				
				claims = new UserClaims(authInfo);
				verifyClaims(claims);

				cacheService.newClaims(idToken, claims);

			} catch (final Exception e) {
				throw new ServletException("Could not obtain user details from token", e);
			}
		} else {
			verifyClaimsExpired(claims);
		}
	
		doNextFilter(request, response, chain);
	}

	private void verifyClaimsExpired(UserClaims claims) {
		int exp = claims.getExpired();
		Date expireDate = new Date(exp * 1000L);
		Date now = new Date();

		if (expireDate.before(now)) {
			throw new RuntimeException("token expired");
		}
	}

	private void doNextFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (chain != null)
			chain.doFilter(request, response);
	}

	private void verifyClaims(UserClaims claims) {
		int exp = claims.getExpired();
		Date expireDate = new Date(exp * 1000L);
		Date now = new Date();

		String iss = claims.getIssuer();
		if (!iss.equals(service.getIssuer())) {
			throw new RuntimeException("Invalid issuer");
		}

		String aud = claims.getAudience();
		if (!aud.equals(service.getClientId())) {
			throw new RuntimeException("Invalid aud");
		}

		if (expireDate.before(now)) {
			throw new RuntimeException("token expired");
		}
	}

	private RsaVerifier verifier(String kid) throws Exception {
		JwkProvider provider = new UrlJwkProvider(new URL(service.getJwks_uri()));
		Jwk jwk = provider.get(kid);
		return new RsaVerifier((RSAPublicKey) jwk.getPublicKey());
	}
}*/