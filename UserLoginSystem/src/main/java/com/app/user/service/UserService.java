package com.app.user.service;

import java.util.List;

import com.app.user.dto.UsersDto;
import com.app.user.exception.UserPresentException;

/**
 * @author swapnil.mane
 *
 */
public interface UserService {
	UsersDto newUserRegistration(UsersDto usersDto) throws UserPresentException;
	
	List<UsersDto>getAllUsers();
	
	public void authenticate(String username, String password);
}
