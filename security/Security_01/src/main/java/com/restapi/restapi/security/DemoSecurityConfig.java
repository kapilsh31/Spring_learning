package com.restapi.restapi.security;

import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add code to access roles/username from custom table
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //arg -- datasource inject prop of database from application prop file
        jdbcUserDetailsManager.setUsersByUsernameQuery("" +
                "select user_id , pw, active from members where user_id = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");

        return new JdbcUserDetailsManager(dataSource);
    }


/*
    // add supports of JDBC to access roles and user

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        //arg -- datasource inject prop of database from application prop file
        return new JdbcUserDetailsManager(dataSource);
    }



 */
/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john  = User.builder()
                .username("john")
                .password("{noop}john")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary  = User.builder()
                .username("mary")
                .password("{noop}mary")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan  = User.builder()
                .username("susan")
                .password("{noop}susan")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        //use http basic auth
        http.httpBasic(Customizer.withDefaults());

        //disable cross site request
        //in general not required for rest apis
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }


 */

}
