/*package com.umedia.zuulgateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
            .authorizeRequests() 
//            .antMatchers(actuatorEndpoints()).hasRole(userConfig.getAdminRole())
//            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers("/login"                         
//                         ,"/new-products/**"
            		).permitAll()
//            .antMatchers("/api/**", "/files/**").authenticated();
            .antMatchers("/**", "/images/**").authenticated();
    }
}
*/