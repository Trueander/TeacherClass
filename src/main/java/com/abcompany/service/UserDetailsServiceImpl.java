package com.abcompany.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcompany.model.MyUserDetails;
import com.abcompany.model.Profesor;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ProfesorService profesorService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Profesor> user = profesorService.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        System.out.println(user.get().getUsername()+", "+user.get().getPassword()+", "+user.get().getRoles());
        return user.map(MyUserDetails::new).get();
	}
	
}
