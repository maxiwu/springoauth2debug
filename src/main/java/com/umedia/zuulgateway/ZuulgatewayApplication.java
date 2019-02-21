package com.umedia.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;


@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class })
@EnableEurekaClient // It acts as a eureka client
//@EnableZuulProxy // Enable Zuul
public class ZuulgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayApplication.class, args);
		
		// new
		// SpringApplicationBuilder(ZuulgatewayApplication.class).properties("spring.config.name=client").run(args);
	}

}
