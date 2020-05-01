package com.example.JavaTest_HighImpact_MarianoWolk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring security config used for
 * controller method auth via
 * basic user name and password
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("james").password("{noop}bond").roles("USER", "ADMIN");
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/atms").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
