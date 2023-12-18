package com.app.user.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.user.dto.UsersDto;
import com.app.user.entity.Users;
import com.app.user.exception.UserPresentException;
import com.app.user.repo.UserRepository;
import com.app.user.service.UserService;
import com.app.user.utility.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author swapnil.mane
 *
 */


/**
 * This class used to write business logic
 *
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	/**
	 * This method used to register new user
	 *
	 */
	@Override
	public UsersDto newUserRegistration(UsersDto usersDto) throws UserPresentException {
		
		Optional<Users> findByEmailAddress = userRepository.findByEmailAddress(usersDto.getEmailAddress());
		if(!findByEmailAddress.isPresent()) {
		Users users = new Users();
		users.setId(usersDto.getId());
		users.setFirstName(usersDto.getFirstName());
		users.setLastName(usersDto.getLastName());
		users.setEmailAddress(usersDto.getEmailAddress());
		users.setPassword(this.passwordEncoder.encode(usersDto.getPassword()));
		users.setIsActive(true);
		// saving to db
		this.userRepository.save(users);
		usersDto.setId(users.getId());
		usersDto.setIsActive(true);
		usersDto.setPassword(this.passwordEncoder.encode(users.getPassword()));
		}else {
			throw new UserPresentException(usersDto.getEmailAddress() + " is already present please try with login");
		}
		return usersDto;
		
	}

	@Override
	public void authenticate(String username, String password) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (Exception e) {
			throw new UsernameNotFoundException("invalid username or password pls try again");
		}

	}
	
	/**
	 * This method used to fetch all users from db
	 *
	 */
	@Override
	public List<UsersDto> getAllUsers() {
		ModelMapper modelMapper = new ModelMapper();
		 List<Users> findAllUsers = this.userRepository.findAll();
		List<UsersDto> collectAllUsers = findAllUsers.stream().map(users->modelMapper.map(users, UsersDto.class)).collect(Collectors.toList());
		return collectAllUsers;
	}

}
