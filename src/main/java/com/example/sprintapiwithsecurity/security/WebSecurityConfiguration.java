//package com.example.sprintapiwithsecurity.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
//public class WebSecurityConfiguration {
//    private final AccountAuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers(GET,  "/api/accounts/**").permitAll()
//                .requestMatchers(POST, "/api/private/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .httpBasic(withDefaults())
//                .sessionManagement()
//                .sessionCreationPolicy(STATELESS);
//        return http.build();
//    }
//}


package com.example.sprintapiwithsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfiguration {
    private final AccountAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(POST, "/api/accounts/**")
                .permitAll()
                .requestMatchers("/**")
                .authenticated()
                .anyRequest()
                .hasAnyRole("USER", "ADMIN")
                .and()
                .authenticationProvider(authenticationProvider)
                .httpBasic(withDefaults())
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);
        return http.build();
    }
}

//***********************************************************************

//
//package com.example.sprintapiwithsecurity.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
////@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfiguration {
//    private final AccountAuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
//        http.csrf().disable();
//        http.authorizeHttpRequests()
//                .requestMatchers(POST, "/api/accounts/**").permitAll();
//                http.authorizeHttpRequests()
//                .anyRequest()
//                .hasAnyRole("USER", "ADMIN")
//                .and()
//                .httpBasic(withDefaults())
//                .sessionManagement()
//                .sessionCreationPolicy(STATELESS);
//                return http.build();
//    }
//}