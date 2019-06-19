package com.example.onlinedelivery.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@EnableWebSecurity
@Configuration
@Order(1000) 
public class ClientWebSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(CbCryptPasswordEncoder());
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers( "/css/**","/fonts/**", "/bower_components/**", 
				"/build/**","/vendor/**", "/js/**", "/images/**", "/dist/**", "/custom/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.headers().frameOptions()
		.sameOrigin()
		.and().
		authorizeRequests()
		.antMatchers("/", "/home", "/login", "/registration").permitAll()
		.anyRequest().authenticated()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/client/**").hasRole("CLIENT")
		.antMatchers("/vendor/**").hasRole("VENDOR")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.loginProcessingUrl("/j_spring_security_check")
		.failureForwardUrl("/login")
		.failureHandler(ClientcustomAuthenticationFailureHandler())
		.defaultSuccessUrl("/client/dashboard")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.and().exceptionHandling()
		.accessDeniedPage("/access");
	}

	@Bean
	public AuthenticationFailureHandler ClientcustomAuthenticationFailureHandler() {
		return new ClientCustomAuthenticationFailureHandler();
	}
	@Bean
	public BCryptPasswordEncoder CbCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
