package com.rikr.rikrapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] AUTHORIZED_LIST = {
        "/v2/api-docs",
        "/swagger-resources/**",
        "/swagger-ui.html",
        "/webjars/springfox-swagger-ui/**",
        "/csrf",
        "/",
        "/error",
        "/info",
        "/health"
    };

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.oauth2ResourceServer().jwt();
    }

    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers(AUTHORIZED_LIST);
    }
}
