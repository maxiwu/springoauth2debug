/*package com.umedia.zuulgateway.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.umedia.zuulgateway.service.B2CService;

@Component
public class ResetPwdFilter extends GenericFilterBean {

	@Autowired
	private B2CService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String authority = service.getResetPasswordAuthorityEndpoint();
		StringBuilder sb = new StringBuilder(authority);
		sb.append("?response_type=").append("code");
		sb.append("&client_id=").append(service.getClientId());
		sb.append("&redirect_uri=").append(service.getRedirectUri());
		sb.append("&scope=").append(service.getScope());

		HttpServletResponse rsp = (HttpServletResponse) response;
		rsp.sendRedirect(sb.toString());
	}

}
*/