package com.ingryd_capstone_project.votingapplication.config;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorization) -> authorization
                     .requestMatchers("/api/v1/login").permitAll()
                     .requestMatchers("/api/v1/allAdmins").hasAnyAuthority(Role.ADMIN.name())
                        .requestMatchers("/api/v1/id").permitAll()
                    .requestMatchers("/api/v1/register").permitAll()
                        .requestMatchers("/**").permitAll()
                        .anyRequest()
                        .authenticated())
                        .sessionManagement(v ->v.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .httpBasic(Customizer.withDefaults());
                     return httpSecurity.build();
    }

}
