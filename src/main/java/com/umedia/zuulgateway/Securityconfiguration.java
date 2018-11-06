/*package com.umedia.zuulgateway;


import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoCustomConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class Securityconfiguration extends OAuth2SsoCustomConfiguration  {
	 @Override
	    public void match(RequestMatchers matchers) {
	      matchers.anyRequest();
	    }

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests().antMatchers("/index.html", "/home.html", "/")
	          .permitAll().anyRequest().authenticated().and().csrf()
	          .csrfTokenRepository(csrfTokenRepository()).and()
	          .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
	    }
	    
	    // the csrf*() methods are the same as the old WebSecurityConfigurerAdapter
}
*/