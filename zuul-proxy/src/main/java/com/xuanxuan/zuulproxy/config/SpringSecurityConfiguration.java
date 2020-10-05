package com.xuanxuan.zuulproxy.config;


import com.xuanxuan.common.JwtUtils.JwtAuthorizationFilter;
import com.xuanxuan.common.JwtUtils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider();
    }

    @Autowired
    private JwtTokenProvider tokenProvider;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/users/**", "/actuator/**", "/test-service/searchPlace").permitAll()
                .anyRequest().fullyAuthenticated().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilter(new JwtAuthorizationFilter(authenticationManager(), tokenProvider));
    }
}
