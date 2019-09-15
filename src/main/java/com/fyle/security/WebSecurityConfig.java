package com.fyle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User
                .withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
