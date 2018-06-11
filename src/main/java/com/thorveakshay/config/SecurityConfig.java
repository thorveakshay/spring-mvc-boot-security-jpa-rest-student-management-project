package com.thorveakshay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/* HTTP BASIC AUTH SETTINGS */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Securing only /api/* routes
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/api/all-students*").hasRole("USER")


      .and().formLogin();
        httpSecurity.csrf().disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{


        // Creating 3 users for http auth

        auth.inMemoryAuthentication().withUser("akshay").password("akshay").roles("USER")
        .and()
        .withUser("john").password("john").roles("USER")
                .and()
                .withUser("sam").password("sam").roles("USER");;
    }



}
