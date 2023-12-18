package com.app.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author swapnil.mane
 *
 */
@Getter
@Setter
public class UsersDto  {
	private Integer id; 
	@NotBlank(message = "Please enter a first name")
	private String firstName;
	@NotBlank(message = "Please enter a last name")
	private String lastName;
	@NotBlank(message = "Please enter a Email Address")
	@Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Please Enter a valid email address")
	private String emailAddress;
	@NotBlank(message = "Please enter a password")
	private String password;
	private Boolean isActive;
	
}
