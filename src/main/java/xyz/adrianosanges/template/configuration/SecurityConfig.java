package xyz.adrianosanges.template.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/fonts/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/admin**").hasRole("ADMIN")
		.anyRequest().authenticated()
		
		.and()
		.formLogin().loginPage("/login").permitAll()

		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")

		.and().exceptionHandling().accessDeniedPage("/403");
		
	}
 
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		return encoder;
	}
 
}