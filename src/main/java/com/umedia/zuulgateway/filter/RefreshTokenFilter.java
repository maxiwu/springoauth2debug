//package com.umedia.zuulgateway.filter;
//
//import java.io.IOException;
//import java.net.URLEncoder;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import com.umedia.zuulgateway.service.B2CService;
//import com.umedia.zuulgateway.util.HttpUtil;
//
//@Component
//public class RefreshTokenFilter extends GenericFilterBean {
//
//	@Autowired
//	private B2CService service;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse rsp = (HttpServletResponse) response;
//
//		String code = req.getParameter("refresh_token");
//		String tokenUrl = service.getTokenEndpoint();
//
//		StringBuilder sb = new StringBuilder();
//		sb.append("grant_type=").append("refresh_token");
//		sb.append("&refresh_token=").append(code);
//		sb.append("&client_id=").append(service.getClientId());
//		sb.append("&client_secret=").append(URLEncoder.encode(service.getClientSecret(), "UTF-8"));
//
//		String result = HttpUtil.sendPost(tokenUrl, sb.toString());
//		HttpUtil.responseJson(rsp, result);
//	}
//
//}
