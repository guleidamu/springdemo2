//package com.example.springdemo.businessSchool.config.security;
//import com.example.springdemo.businessSchool.service.CustomerUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private SecurityAccessDeniedHandler deniedHandler;
//
//    @Autowired
//    private SecurityAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    private CustomerUserDetailService userDetailService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/logins", "/annymous","/swagger-ui.html/**","/Permission/**","/student/**","/Permission/**").permitAll()
//                .antMatchers("/user/**").hasRole("user")
//                .anyRequest().authenticated()
//                .and().
//                httpBasic().disable()
//                .formLogin().disable()
//                .csrf().disable()
//                .exceptionHandling()
//                .accessDeniedHandler(deniedHandler)
//                .authenticationEntryPoint(authenticationEntryPoint)
//        ;
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//}
