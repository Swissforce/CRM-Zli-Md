package ch.zli.m223.ksh19a.md.CRM.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.ksh19a.md.CRM.roles.AppRoles;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	UserDetailsService userDetailsService;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureWeb(http);
		configureRest(http);
	}

	private void configureRest(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement()
				.disable()
				.httpBasic();
		
	}

	private void configureWeb(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/admin/**").hasAuthority(AppRoles.ADMIN)
				.antMatchers("/user/**").hasAuthority(AppRoles.USER)
				.antMatchers("/customers/**").hasAuthority(AppRoles.USER)
				.antMatchers("/logedin").authenticated()
				//.anyRequest().authenticated()
			.and()
				.formLogin().permitAll()
			.and()
				.logout().permitAll();
	}
}
