package com.mbarekdev.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
@Bean
public InMemoryUserDetailsManager userDetailsManager(){
    UserDetails john = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build();
    UserDetails mary = User.builder()
            .username("mary")
            .password("{noop}test123")
            .roles("EMPLOYEE","MANAGER")
            .build();
    UserDetails susan = User.builder()
            .username("susan")
            .password("{noop}test123")
            .roles("EMPLOYEE", "ADMIN","MANAGER")
            .build();
    return new InMemoryUserDetailsManager(john,mary,susan);
}


@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
    return httpSecurity.authorizeHttpRequests(config-> config
            .requestMatchers("/").hasRole("EMPLOYEE")
            .requestMatchers("/leaders/**").hasRole("MANAGER")
            .requestMatchers("/systems/**").hasRole("ADMIN")
            .anyRequest()
            .authenticated())
            .formLogin(from -> from
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
            )
            .logout(logout->logout.permitAll()
            ).exceptionHandling(configer ->configer.accessDeniedPage("/access-denied"))
            .build();
}

}
