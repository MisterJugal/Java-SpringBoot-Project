package com.credentialRoles.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.credentialRoles.Repo.MyUserRepository;
import com.credentialRoles.entity.MyUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MyUserRepository myUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser fetchedUser= myUserRepository.findById(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		
		return User.builder()
				.username(fetchedUser.getUserName())
				.password(fetchedUser.getPassword())
				.roles(fetchedUser.getRole())
				.build();
	}

	
}
