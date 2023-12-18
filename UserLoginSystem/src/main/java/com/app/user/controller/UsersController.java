package com.app.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.dto.UsersDto;
import com.app.user.entity.Users;
import com.app.user.exception.UserPresentException;
import com.app.user.model.ReturnData;
import com.app.user.repo.UserRepository;
import com.app.user.security.JwtAuthRequest;
import com.app.user.security.JwtAuthResponse;
import com.app.user.security.JwtService;
import com.app.user.security.UserInfoUserDetailsService;
import com.app.user.service.UserService;
import com.app.user.utility.Constants;

import jakarta.validation.Valid;

/**
 * @author swapnil.mane
 *
 */
@RestController
public class UsersController {

	/**
	 * New USER_REGISTRATION.
	 */
	private static final String USER_REGISTRATION = "/user/registration";
	
	/**
	 *  USER_LOGIN.
	 */
	private static final String USER_LOGIN = "/user/login";
	
	/**
	 *  GET_ALL_USERS from db.
	 */
	private static final String GET_ALL_USERS = "/user/getallusers";


	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserInfoUserDetailsService userInfoUserDetailsService;

	
	@PostMapping(path = USER_REGISTRATION)
	public ResponseEntity<?> newUserRegistration(@Valid @RequestBody UsersDto usersDto) throws UserPresentException {
		ReturnData data = new ReturnData();
		UsersDto returnData = this.userService.newUserRegistration(usersDto);
		data.setData(returnData);
		data.setMessage(Constants.NEW_USER);
		data.setStatusCode(Constants.SUCCESS_CODE);
		return new ResponseEntity<ReturnData>(data, HttpStatus.OK);
	}

	@PostMapping(path = USER_LOGIN)
	public ResponseEntity<?> userLogin(@RequestBody JwtAuthRequest jwtAuthRequest) {

		this.userService.authenticate(jwtAuthRequest.getUsername(), jwtAuthRequest.getPassword());
		
		UserDetails userDetails = this.userInfoUserDetailsService.loadUserByUsername(jwtAuthRequest.getUsername());

		//userRepository.findByEmailAddress(jwtAuthRequest.getUsername());
		
		String username = jwtAuthRequest.getUsername();
		
		String token = this.jwtService.generateToken(userDetails);

		return ResponseEntity.ok(new JwtAuthResponse(username, token));

	}
	
	@GetMapping(path = GET_ALL_USERS)
	public ResponseEntity<?> getAllUsers(){
		List<UsersDto> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<UsersDto>>(allUsers, HttpStatus.OK);
	}
	
}
