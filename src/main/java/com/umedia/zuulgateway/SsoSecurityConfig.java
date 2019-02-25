package com.umedia.zuulgateway;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//working
@Configuration
@EnableOAuth2Sso
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {// OAuth2SsoConfigurerAdapter
																		// {
	// @Override
	// public void configure(HttpSecurity http) throws Exception {
	// 	http.csrf().disable().cors().disable().logout().and().antMatcher("/**").authorizeRequests()
	// 			.antMatchers("/index.html", "/", "/login").permitAll().anyRequest().authenticated().and()
	// 			.csrf().disable();
	// }

	//https://www.baeldung.com/sso-spring-security-oauth2
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
          .authorizeRequests()
          .antMatchers("/", "/login**")
          .permitAll()
          .anyRequest()
          .authenticated();
    }
}


//sample
/*@Configuration
@EnableOAuth2Sso
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired
	// @Qualifier("resourceServerRequestMatcher")
	// private RequestMatcher resources;
	@Bean("AllRequestMatcher")
	public RequestMatcher resources() {
		return new AntPathRequestMatcher("/res/**");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// RequestMatcher nonResoures = new NegatedRequestMatcher(resources);

		http.requestMatcher(resources()).authorizeRequests().anyRequest().authenticated();
	}
}*/