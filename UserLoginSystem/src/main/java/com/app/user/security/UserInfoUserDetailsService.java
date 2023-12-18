package com.app.user.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.app.user.entity.Users;
import com.app.user.repo.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users orElseThrow = this.userRepository.findByEmailAddress(username).orElseThrow(()->new UsernameNotFoundException(username +" Not Found "));
		return orElseThrow;
	}
	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Optional<Users> findByEmailAddress = this.userRepository.findByEmailAddress(username);
//		return findByEmailAddress.map(UsersLoginDto::new)
//		.orElseThrow(()-> new UsernameNotFoundException("User not foundd : "+username));
//	}

}
