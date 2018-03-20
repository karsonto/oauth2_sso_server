package com.karson.webmagic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 
	@Autowired
	private UserDetailsService userDetailsService;
 
 /**   @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests()
         .antMatchers("/bower_components/**","/oauth/authorize","/login"         
         ).permitAll() //默认不拦截静态资源的url pattern （2）
         .anyRequest().authenticated().and()
         .formLogin().loginPage("/login")// 登录url请求路径 (3)
          .permitAll(); 
    }*/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .formLogin().loginPage("/login").permitAll()
         .and()
         .logout()
         .and()
         .requestMatchers()
         .antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access", "/exit")
         .and()
         .authorizeRequests()
         .antMatchers("/webjars/**").permitAll()
         .anyRequest().authenticated();
          
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	  auth.userDetailsService(userDetailsService); 
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/bower_components/**");
    }

}
