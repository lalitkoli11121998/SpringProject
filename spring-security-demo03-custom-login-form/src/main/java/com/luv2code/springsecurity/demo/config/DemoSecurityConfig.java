package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER","ADMIN"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"))
			.withUser(users.username("ravi").password("test123").roles("TEACHER", "MANAGER","EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE") // IT means the user which has role employee can access the home page
		.antMatchers("/leaders/*").hasRole("MANAGER")// IT means the user which has role manager can access the leader page
		.antMatchers("/admins/*").hasRole("ADMIN")
//        .anyRequest()  //it means every request can access the home page
//        .authenticated()  //check user is authenticated or onot
        .and()
        .formLogin() //we are customizing the form login process
        .loginPage("/showMyLoginPage") //specifiy the login page
        .loginProcessingUrl("/authenticateTheUser")  //login form should post data to this url and spring automatically handle the login functionaity
        .permitAll() //allow everyone to see the login page without logged in
        .and()
        .logout() //logout the user
        .permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	
	
}






