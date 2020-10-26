package com.agroshop.app.security;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private IUserRepository repo;
	
	private static final Logger logger = LogManager.getLogger(CustomUserDetailsService.class);	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = repo.findOneByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		/*
		List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(user.getProfile().getName()));
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), roles);
		*/
		
		
		//UserPrincipal userPrincipal= new UserPrincipal(user);
		//logger.info(userDetails.toString());
		
		
		return new UserPrincipal(user);
		
	}
	
}
