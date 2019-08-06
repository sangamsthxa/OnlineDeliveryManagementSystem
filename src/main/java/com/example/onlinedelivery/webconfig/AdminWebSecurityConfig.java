package com.example.onlinedelivery.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.authorizeRequests()
			    .antMatchers("/", "/home", "/login", "/registration","/aboutUs",
			    		"/services").permitAll()
			    .antMatchers("/admin/**").hasRole("ADMIN")
			    .antMatchers("/vendors/**").hasRole("VENDOR")
			    .antMatchers("/client/**").hasRole("CLIENT")
			    .anyRequest().authenticated()
			    
			    .and()
			    .formLogin()
			    .loginPage("/login").permitAll()
			    .loginProcessingUrl("/j_spring_security_check")
			    .permitAll()
			    .usernameParameter("username")
				.passwordParameter("password")
			    .failureForwardUrl("/login")
			    .defaultSuccessUrl("/dashboard")
			    .and()
			    .logout()
			    .logoutUrl("/logout")
			    .logoutSuccessUrl("/login")
			    .deleteCookies("JSESSIONID")
			    .invalidateHttpSession(true)
			    .and().exceptionHandling()
			    .accessDeniedPage("/access")
			    .and()
				.headers()
				.defaultsDisabled()
				.frameOptions()
				.sameOrigin()
				.cacheControl();

		}
		 

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/fonts/**", 
				"/bower_components/**", "/build/**", "/vendor/**", "/js/**",
				"/images/**", "/dist/**", "/custom/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(cryptPasswordEncoder());
	}

	@Bean
	public static AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean("cryptPasswordEncoder")
	public BCryptPasswordEncoder cryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect sec) {
	    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.addDialect(sec); // Enable use of "sec"
	    return templateEngine;
	}
}