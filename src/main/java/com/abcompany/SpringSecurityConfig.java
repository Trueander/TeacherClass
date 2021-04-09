package com.abcompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
    @Qualifier("customSuccessHandler")
    private SimpleUrlAuthenticationSuccessHandler handler;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(detailsService);
		auth.authenticationProvider(daoAuthenticationProvider());
		
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/index/**").permitAll()
                .antMatchers("/dashboard/**","/clase/**",
                		"/editar_clase/**","/reporteEstudiante/**","/removePoints/**","/addPoints/**","/delete_E/**").hasAnyRole("USER")
                .and()
                .formLogin()
                	.loginPage("/login")
		                .permitAll()
		                .successHandler(handler)
                .and()
                .exceptionHandling().accessDeniedPage("/error")
                .and()
                .csrf();
    }
	
	 //Este bean define el tipo de cifrado
    @Bean
    public PasswordEncoder passwordEncoder(){
        
        PasswordEncoder pe = new BCryptPasswordEncoder();
        
        return pe;
    }
    
    //Este bean define las proviciones para el autenticado
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        
        //objeto proveedor
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        
        dap.setUserDetailsService(detailsService);
        dap.setPasswordEncoder(passwordEncoder());
        
        return dap;
    }
	
	
	
	
	
}
