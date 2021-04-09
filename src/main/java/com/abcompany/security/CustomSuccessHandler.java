package com.abcompany.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private RedirectStrategy rs = new DefaultRedirectStrategy();
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String targetUrl = this.determineTargetUrl(authentication);
		rs.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		
		String url = null;
		
		Collection<String> roles = new ArrayList<>();
		
		for(GrantedAuthority role: authentication.getAuthorities()) {
			roles.add(role.getAuthority());
		}
		
		System.out.println(roles);
		
		if(roles.contains("ROLE_ADMIN")) {
			url="/listar_p";
		}else if(roles.contains("ROLE_USER")) {
			url="/dashboard";
		}else {
			url = "/error";
		}
		
		return url;
	}
	
}
