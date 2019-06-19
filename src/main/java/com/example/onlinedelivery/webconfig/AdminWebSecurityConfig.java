package com.example.onlinedelivery.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class AdminWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
/*	@Override
	public void init(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/css/**", "/js/**", "/images/**", "/fonts/**",
				"/bower_components/**", "/build/**", "/custom/**", "/dist/**", "/plugins/**", "/vendor/**");
	}*/
	
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
		.failureHandler(customAuthenticationFailureHandler())
		.defaultSuccessUrl("/admin/dashboard")
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
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}