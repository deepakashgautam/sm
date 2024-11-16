package com.scm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    //user create and login using java code within memory service
   /* @Bean
    public InMemoryUserDetailsManager userDetailService() {
        //implement user details service using in-memory user service

    /*user1 UserDetails user = User
                .withDefaultPasswordEncoder()
                        .username("admin123")
                        .password("admin123")
                        .roles("ADMIN","ADMIN")
                        .build();

    /*user2  UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("user123")
                .password("user123")
                .build();

                //add more users if needed

        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user);
        return inMemoryUserDetailsManager;
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //Hume lana hai user details service ka object
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        //Hume lana hai password service ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
