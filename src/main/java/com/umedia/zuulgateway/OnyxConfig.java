/*package com.umedia.zuulgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.umedia.zuulgateway.filter.B2CLoginFilter;
import com.umedia.zuulgateway.filter.B2CLogoutFilter;
import com.umedia.zuulgateway.filter.CodeHandlerFilter;
import com.umedia.zuulgateway.filter.OidcFilter;
import com.umedia.zuulgateway.filter.RefreshTokenFilter;
import com.umedia.zuulgateway.filter.ResetPwdFilter;

@Configuration
public class OnyxConfig {

	@Autowired
	private Environment env;

	@Autowired
	private B2CLoginFilter mLoginFilter;

	@Autowired
	private RefreshTokenFilter mRefreshFilter;

	@Autowired
	private B2CLogoutFilter mLoginoutFilter;

	@Autowired
	private ResetPwdFilter mResetPwdFilter;

	@Autowired
	private CodeHandlerFilter mCodeHandlerFilter;

	@Autowired
	private OidcFilter mOidcFilter;

	@Bean
	public FilterRegistrationBean refreshFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		String mapping = env.getProperty("b2c.mapping.refresh_token");
		registrationBean.setFilter(mRefreshFilter);
		registrationBean.addUrlPatterns(mapping);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean logoutFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		String mapping = env.getProperty("b2c.mapping.logout");
		registrationBean.setFilter(mLoginoutFilter);
		registrationBean.addUrlPatterns(mapping);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean resetPasswordFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		String mapping = env.getProperty("b2c.mapping.passwordReset");
		registrationBean.setFilter(mResetPwdFilter);
		registrationBean.addUrlPatterns(mapping);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean loginFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		String mapping = env.getProperty("b2c.mapping.login");
		registrationBean.setFilter(mLoginFilter);
		registrationBean.addUrlPatterns(mapping);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean codeHandleFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		String mapping = env.getProperty("b2c.mapping.authcode");
		registrationBean.setFilter(mCodeHandlerFilter);
		registrationBean.addUrlPatterns(mapping);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean userFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(mOidcFilter);
		registrationBean.addUrlPatterns("/user/*");
		return registrationBean;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // you USUALLY want this
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
*/